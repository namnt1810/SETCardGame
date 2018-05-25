package com.example.lap11877_local.setcardgame;

import com.example.lap11877_local.setcardgame.Features.Color;
import com.example.lap11877_local.setcardgame.Features.Count;
import com.example.lap11877_local.setcardgame.Features.Shading;
import com.example.lap11877_local.setcardgame.Features.Shape;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class Deck {
    private final int POSITION_NONE = -1;

    private int TOTAL_CARDS = 81;

    private final Card[] mDeck = new Card [TOTAL_CARDS];

    private final Map<String, Integer> mCardResIdMap = new HashMap<>();

    private Random mRandom = new Random();

    private int mCardsLeft = TOTAL_CARDS;

    public Deck(){
        makeDeck();
        makeImagesResourceMap();
    }

    private void makeDeck(){
        Count[] counts = Count.values();
        Shading[] shadings = Shading.values();
        Shape[] shapes = Shape.values();
        Color[] colors = Color.values();
        int cardsIndex = 0;

        Count count;
        Color color;
        Shading shading;
        Shape shape;

        for (int colorIndex = 0; colorIndex < colors.length; colorIndex++) {
            for (int shapeIndex = 0; shapeIndex < shapes.length; shapeIndex++) {
                for (int shadingIndex = 0; shadingIndex < shadings.length; shadingIndex++) {
                    for (int countIndex = 0; countIndex < counts.length; countIndex++) {
                        count = counts[countIndex];
                        color = colors [colorIndex];
                        shading = shadings[shadingIndex];
                        shape = shapes [shapeIndex];

//                        String cardIdString = String.format(Locale.getDefault(),
//                                Card.CARD_ID_FORMAT,
//                                countIndex, colorIndex, shadingIndex, shapeIndex);

                        Card card = new Card(count, color, shading, shape);
//                        Integer cardImageResId = mCardResIdMap.get(cardIdString);
//                        card.setImageRes(cardImageResId);

                        mDeck[cardsIndex] = card;
                        cardsIndex++;

                    }
                }
            }
        }
    }

    private void makeImagesResourceMap() {
        //TODO: initialize resource map here, do manually.
        mCardResIdMap.put("0000", R.drawable.blue_card_01);
    }

    public Card[] makeTable(){
        int tableSize = 12;
        Card[] table = new Card[tableSize];
        int selectIndex;

        for (int tableIndex = 0; tableIndex < tableSize; tableIndex++) {
            selectIndex = getAvailableIndex();
            if (selectIndex != POSITION_NONE ) {
                table[tableIndex] = mDeck[selectIndex];
                mDeck[selectIndex] = null;
                mCardsLeft--;
            }
        }
        return table;
    }

    public int getAvailableIndex(){
        if(isEmpty()) {
            return POSITION_NONE;
        }
        int randomIndex = mRandom.nextInt(TOTAL_CARDS);
        while(!isAvailable(randomIndex)){
            randomIndex = mRandom.nextInt(TOTAL_CARDS);
        }
        return randomIndex;
    }

    public boolean isEmpty(){
        return mCardsLeft == 0;
    }

    public boolean isAvailable(int randomIndex){
        return isValidIndex(randomIndex) && mDeck[randomIndex] != null;
    }

    public boolean isValidIndex (int randomIndex){
        return 0 <= randomIndex && randomIndex < TOTAL_CARDS;
    }

    public Card[] generateCards(int numberOfCardsToGenerate) {
        if (isEmpty()) {
            // Game end, no more cards left.
            return null;
        }

        Card[] cards = new Card[numberOfCardsToGenerate];
        for(int i = 0; i < numberOfCardsToGenerate; i++) {
            int availableIndex = getAvailableIndex();
            if (POSITION_NONE != availableIndex) {
                cards[i] = mDeck[availableIndex];
            }
        }
        return cards;
    }
}
