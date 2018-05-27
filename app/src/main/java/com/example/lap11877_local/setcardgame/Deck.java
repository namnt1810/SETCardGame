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

                        Card card = new Card(count, color, shading, shape);

                        String cardIdString = String.format(Locale.getDefault(),
                                Card.CARD_ID_FORMAT,
                                countIndex, colorIndex, shadingIndex, shapeIndex);

                        Integer cardImageResId = mCardResIdMap.get(cardIdString);
                        card.setImageRes(cardImageResId);

                        mDeck[cardsIndex] = card;
                        cardsIndex++;

                    }
                }
            }
        }
    }

    private void makeImagesResourceMap() {
        //TODO: initialize resource map here, do manually.

        mCardResIdMap.put("0000", R.drawable.card_0000);

        mCardResIdMap.put("0001", R.drawable.card_0001);

        mCardResIdMap.put("0002", R.drawable.card_0002);

        mCardResIdMap.put("0010", R.drawable.card_0010);

        mCardResIdMap.put("0011", R.drawable.card_0011);

        mCardResIdMap.put("0012", R.drawable.card_0012);

        mCardResIdMap.put("0020", R.drawable.card_0020);

        mCardResIdMap.put("0021", R.drawable.card_0021);

        mCardResIdMap.put("0022", R.drawable.card_0022);

        mCardResIdMap.put("0100", R.drawable.card_0100);

        mCardResIdMap.put("0101", R.drawable.card_0101);

        mCardResIdMap.put("0102", R.drawable.card_0102);

        mCardResIdMap.put("0110", R.drawable.card_0110);

        mCardResIdMap.put("0111", R.drawable.card_0111);

        mCardResIdMap.put("0112", R.drawable.card_0112);

        mCardResIdMap.put("0120", R.drawable.card_0120);

        mCardResIdMap.put("0121", R.drawable.card_0121);

        mCardResIdMap.put("0122", R.drawable.card_0122);

        mCardResIdMap.put("0200", R.drawable.card_0200);

        mCardResIdMap.put("0201", R.drawable.card_0201);

        mCardResIdMap.put("0202", R.drawable.card_0202);

        mCardResIdMap.put("0210", R.drawable.card_0210);

        mCardResIdMap.put("0211", R.drawable.card_0211);

        mCardResIdMap.put("0212", R.drawable.card_0212);

        mCardResIdMap.put("0220", R.drawable.card_0220);

        mCardResIdMap.put("0221", R.drawable.card_0221);

        mCardResIdMap.put("0222", R.drawable.card_0222);

        mCardResIdMap.put("1000", R.drawable.card_1000);

        mCardResIdMap.put("1001", R.drawable.card_1001);

        mCardResIdMap.put("1002", R.drawable.card_1002);

        mCardResIdMap.put("1010", R.drawable.card_1010);

        mCardResIdMap.put("1011", R.drawable.card_1011);

        mCardResIdMap.put("1012", R.drawable.card_1012);

        mCardResIdMap.put("1020", R.drawable.card_1020);

        mCardResIdMap.put("1021", R.drawable.card_1021);

        mCardResIdMap.put("1022", R.drawable.card_1022);

        mCardResIdMap.put("1100", R.drawable.card_1100);

        mCardResIdMap.put("1101", R.drawable.card_1101);

        mCardResIdMap.put("1102", R.drawable.card_1102);

        mCardResIdMap.put("1110", R.drawable.card_1110);

        mCardResIdMap.put("1111", R.drawable.card_1111);

        mCardResIdMap.put("1112", R.drawable.card_1112);

        mCardResIdMap.put("1120", R.drawable.card_1120);

        mCardResIdMap.put("1121", R.drawable.card_1121);

        mCardResIdMap.put("1122", R.drawable.card_1122);

        mCardResIdMap.put("1200", R.drawable.card_1200);

        mCardResIdMap.put("1201", R.drawable.card_1201);

        mCardResIdMap.put("1202", R.drawable.card_1202);

        mCardResIdMap.put("1210", R.drawable.card_1210);

        mCardResIdMap.put("1211", R.drawable.card_1211);

        mCardResIdMap.put("1212", R.drawable.card_1212);

        mCardResIdMap.put("1220", R.drawable.card_1220);

        mCardResIdMap.put("1221", R.drawable.card_1221);

        mCardResIdMap.put("1222", R.drawable.card_1222);

        mCardResIdMap.put("2000", R.drawable.card_2000);

        mCardResIdMap.put("2001", R.drawable.card_2001);

        mCardResIdMap.put("2002", R.drawable.card_2002);

        mCardResIdMap.put("2010", R.drawable.card_2010);

        mCardResIdMap.put("2011", R.drawable.card_2011);

        mCardResIdMap.put("2012", R.drawable.card_2012);

        mCardResIdMap.put("2020", R.drawable.card_2020);

        mCardResIdMap.put("2021", R.drawable.card_2021);

        mCardResIdMap.put("2022", R.drawable.card_2022);

        mCardResIdMap.put("2100", R.drawable.card_2100);

        mCardResIdMap.put("2101", R.drawable.card_2101);

        mCardResIdMap.put("2102", R.drawable.card_2102);

        mCardResIdMap.put("2110", R.drawable.card_2110);

        mCardResIdMap.put("2111", R.drawable.card_2111);

        mCardResIdMap.put("2112", R.drawable.card_2112);

        mCardResIdMap.put("2120", R.drawable.card_2120);

        mCardResIdMap.put("2121", R.drawable.card_2121);

        mCardResIdMap.put("2122", R.drawable.card_2122);

        mCardResIdMap.put("2200", R.drawable.card_2200);

        mCardResIdMap.put("2201", R.drawable.card_2201);

        mCardResIdMap.put("2202", R.drawable.card_2202);

        mCardResIdMap.put("2210", R.drawable.card_2210);

        mCardResIdMap.put("2211", R.drawable.card_2211);

        mCardResIdMap.put("2212", R.drawable.card_2212);

        mCardResIdMap.put("2220", R.drawable.card_2220);

        mCardResIdMap.put("2221", R.drawable.card_2221);

        mCardResIdMap.put("2222", R.drawable.card_2222);
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
                mDeck[availableIndex] = null;
                mCardsLeft--;
            }
        }
        return cards;
    }
}
