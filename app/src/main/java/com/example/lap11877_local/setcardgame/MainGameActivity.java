package com.example.lap11877_local.setcardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
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

    private SetGame mGame;

    private Set<Integer> mSelectedCardIds;


    /** initViews() method used to find View by Id
     */
    private void initViews() {
        int length = mViewIds.length;
        mImageViews = new ImageView[length];
        for (int i = 0; i < length; i++) {
            mImageViews[i] = findViewById(mViewIds[i]);
            mImageViews[i].setOnClickListener(this);
//            Card cardFromViewId = mGame.getTable().getCardFromViewId(mViewIds[i]);
//            mImageViews[i].setImageResource(cardFromViewId.getImageRes());
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcard_game);
        initViews();
        mGame = new SetGame(); //new game
        mGame.matchingViewIds(mViewIds); //connect id to card indices
        mSelectedCardIds = new HashSet<>();
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

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (mSelectedCardIds.contains(id)) {
            mSelectedCardIds.remove(id);// Check if re-select
            return;
        }
        // otherwise, add the selected ID to set.
        mSelectedCardIds.add(id);

        if (3 != mSelectedCardIds.size()){
            return;
        }

        //SetGame handles all the logic of games!!!

        GameTable table = mGame.getTable();
        if (table != null) {

            int[] selectedViewIds = asArray();
            Card[] selectedCards = new Card[selectedViewIds.length];
            for (int i = 0; i < selectedViewIds.length; i++) {
                selectedCards[i] = mGame.getSelectedCard(selectedViewIds[i]);
            }

            //check if there is an index = -1
            if (mGame.isSet(selectedCards[0], selectedCards[1], selectedCards[2])) {
                //TODO: logic to handle if 3 cards are a set.
                table.removeCardsByViewIds(mSelectedCardIds);
                int[] emptyPositions = table.getEmptyCardPositions();
                table.refill(mGame.generateNextCards());
                table.matchingElements(selectedViewIds, emptyPositions);
                mSelectedCardIds.clear();
                Toast.makeText(this, "One SET found", Toast.LENGTH_SHORT).show();
            } else {
                //TODO: not a set, your logic goes here.

                mSelectedCardIds.clear();
                Toast.makeText(this, "Not a SET", Toast.LENGTH_SHORT).show();
            }
//            if (!mGame.isSet(selectedCards[0], selectedCards[1], selectedCards[2])){
//                System.out.println("Not a Set. Please choose three cards again");
//
//                //remove elements in mSelectedCardIds?
//                Iterator<Integer> iterator1 = mSelectedCardIds.iterator();
//                while (iterator1.hasNext()) {
//                    iterator1.remove();
//                }
//
//                return;
//            }

            //remove elements in mSelectedCardIds



            // TODO: implement your logic to check cards are a set here.
            // 1. Check a set
            // 2. Reset cards, clear selected cards.

            // iterate over selected card IDs, reset its background.
            //mSelectedCardIds.clear();
        }


        // 2. Validate the selected cards if they're a set.
        // 3. Reset cards background to default after processed above steps.


//        int viewId = v.getId();
//        Card card = mViewIdToCards.get(viewId);
//        Toast.makeText(this, card.toString(), Toast.LENGTH_SHORT).show();
    }
}
