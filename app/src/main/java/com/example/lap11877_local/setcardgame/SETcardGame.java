package com.example.lap11877_local.setcardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.HashSet;
import java.util.Set;

public class SETcardGame extends AppCompatActivity implements View.OnClickListener {

    private ImageView[] mImageViews;

    private final int[] resourceIds = {
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

    private Set<Integer> mSelectedCardIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setcard_game);

        mSelectedCardIds = new HashSet<>();

        int length = resourceIds.length;
        mImageViews = new ImageView[length];
        for (int i = 0; i < length; i++) {
            mImageViews[i] = findViewById(resourceIds[i]);
            mImageViews[i].setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        // 1. Check number of card was selected, is it less than or equal 3;
        // 1.1 How to instruct computer which cards are selected? => data structure.
        // 1.2 How to know number of selected cards.


        int id = v.getId();
        if (mSelectedCardIds.contains(id)) { // Check if re-select
            // Nothing to do here since this card exists in selected cards.
            return;
        }

        // otherwise, add the selected ID to set.
        mSelectedCardIds.add(id);

        if (3 == mSelectedCardIds.size()) {
            // TODO: implement your logic to check cards are a set here.
            // 1. Check a set
            // 2. Reset cards, clear selected cards.

            // iterate over selected card IDs, reset its background.
            //mSelectedCardIds.clear();
        }


        // 2. Validate the selected cards if they're a set.
        // 3. Reset cards background to default after processed above steps.

    }
}
