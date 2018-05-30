package com.example.lap11877_local.setcardgame;

import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainGameActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView[] mImageViews;

    private final int[] mViewIds = {
            R.id.image1,
            R.id.image2,
            R.id.image3,
            R.id.image4,
            R.id.image5,
            R.id.image6,
            R.id.image7,
            R.id.image8,
            R.id.image9,
            R.id.image10,
            R.id.image11,
            R.id.image12
    };

    private TextView mScoreView;

    private SetGame mGame;

    private Set<Integer> mSelectedCardIds;

    private int mScore = 0;

    private Handler mHandler = new Handler();

    /** initViews() method used to find View by Id
     */
    private void initViews() {
        int length = mViewIds.length;
        mImageViews = new ImageView[length];
        for (int i = 0; i < length; i++) {
            mImageViews[i] = findViewById(mViewIds[i]);
            mImageViews[i].setOnClickListener(this);
        }

        View mShuffleButton;

        View mRuleButton;

        mScoreView = findViewById(R.id.score_button);
        mScoreView.setText(String.format("SCORE: 0"));

        mShuffleButton = findViewById(R.id.shuffle_button);
        mShuffleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shuffleTable();
                mScore--;
                mScoreView.setText(String.format("SCORE: %d", mScore));
            }
        });

        mRuleButton = findViewById(R.id.rule_button);
        mRuleButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rule_description();
           }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcard_game);
        initViews();
        mGame = new SetGame(); //new game
        mGame.matchingViewIds(mViewIds); //connect id to card indices

        for (int i = 0; i < mViewIds.length ; i++) {
            Card cardFromViewId = mGame.getTable().getCardFromViewId(mViewIds[i]);
            mImageViews[i].setImageResource(cardFromViewId.getImageRes());
        }

        mSelectedCardIds = new HashSet<>();
    }

    private void rule_description(){
        DialogFragment newFragment = new Rule();
        newFragment.show(getSupportFragmentManager(), "back");
    }


    private int[] asArray() {
        int size = mSelectedCardIds.size();
        int[] ids = new int[size];
        Iterator<Integer> iterator = mSelectedCardIds.iterator();
        for(int i = 0; i < size; i++) {
            ids[i] = iterator.next();
        }
        return ids;
    }

    private void shuffleTable() {
        mGame.getTable().resetCardStatusInTable();
        GameTable newTable = new GameTable(mGame.shuffleTable());
        mGame.setTable(newTable);
        mGame.matchingViewIds(mViewIds);
        for (int i = 0; i < mViewIds.length ; i++) {
            Card cardFromViewId = mGame.getTable().getCardFromViewId(mViewIds[i]);
            mImageViews[i].setImageResource(cardFromViewId.getImageRes());
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (mSelectedCardIds.contains(id)) {
            mSelectedCardIds.remove(id);// Check if re-select
            v.setSelected(false);
            return;
        }
        // otherwise, add the selected ID to set.
        mSelectedCardIds.add(id);
        v.setSelected(true);

        if (3 != mSelectedCardIds.size()){
            return;
        }

        final GameTable table = mGame.getTable();
        if (table != null) {

            final int[] selectedViewIds = asArray();
            Card[] selectedCards = new Card[selectedViewIds.length];
            for (int i = 0; i < selectedViewIds.length; i++) {
                selectedCards[i] = mGame.getSelectedCard(selectedViewIds[i]);
            }

            if (mGame.isSet(selectedCards[0], selectedCards[1], selectedCards[2])) {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clearSelectedViews();
                        Toast.makeText(MainGameActivity.this, "One SET found", Toast.LENGTH_SHORT).show();
                        mScore++;
                        setScore();
                        table.removeCardsByViewIds(mSelectedCardIds);
                        int[] emptyPositions = table.getEmptyCardPositions();
                        Card[] generatedCards = mGame.generateNextCards();
                        table.refill(generatedCards);
                        table.matchingElements(selectedViewIds, emptyPositions);
                        for (int i = 0; i < selectedViewIds.length; i++) {
                           ImageView selectedView = findViewById(selectedViewIds[i]);
                           selectedView.setImageResource(generatedCards[i].getImageRes());
                        }
                        mSelectedCardIds.clear();
                    }
                }, 1000L);

            } else {
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        clearSelectedViews();
                        mSelectedCardIds.clear();
                        Toast.makeText(MainGameActivity.this, "Not a SET", Toast.LENGTH_SHORT).show();
                    }
                }, 1000L);
            }
        }
    }

    private void clearSelectedViews() {
        for (Integer cardId : mSelectedCardIds) {
            View imageView = findViewById(cardId);
            if (imageView != null) {
                imageView.setSelected(false);
            }
        }
    }

    private void setScore() {
        mScoreView.setText(String.format("SCORE: %d", mScore));
    }

    @Override
    protected void onDestroy() {
        if (mHandler != null) {
            mHandler.removeCallbacks(null);
        }
        super.onDestroy();
    }
}