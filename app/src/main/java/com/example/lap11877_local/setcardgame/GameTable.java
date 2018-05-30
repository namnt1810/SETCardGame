package com.example.lap11877_local.setcardgame;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GameTable {
    public static final int NO_INDEX = -1;

    private Card[] mCards;

    private final int NUM_OF_TABLE_CARDS = 12;

    private Set<Integer> mEmptyPositions;

    private Map<Integer, Integer> mViewIdsToCardIndices;

    public GameTable(Card[] cards){
        if (cards != null && cards.length >0){
            mCards = new Card[NUM_OF_TABLE_CARDS];
            int count = Math.min(NUM_OF_TABLE_CARDS, cards.length);
            for (int i = 0; i < count ; i++) {
                mCards[i] = cards[i];
            }
        }
        mEmptyPositions = new HashSet<>();
        mViewIdsToCardIndices = new HashMap<>();
    }

    public Card remove (int pos){
        Card oldCard = null;
        if (isValidIndex(pos)){
            oldCard = mCards[pos];
            mCards[pos]= null;
            mEmptyPositions.add(pos);
        }
        return oldCard;
    }

    public void refill (Card[] cardsToFill){
        //check if cardsToFill is invalid or empty
        if (cardsToFill == null || cardsToFill.length == 0){
            System.out.println ("cardsToFill is invalid or empty");
            return;
        }

        int iteration = Math.min(cardsToFill.length, mEmptyPositions.size());
            Iterator<Integer> iterator = mEmptyPositions.iterator();
            Integer emptyPos;
            for (int i = 0; i < iteration; i++) {
                emptyPos = iterator.next();
                mCards[emptyPos] = cardsToFill[i];
                iterator.remove();
            }
    }

    public boolean isValidIndex (int index){
        return 0<= index && index < NUM_OF_TABLE_CARDS;
    }

    /**matchingAll method matches 12 views' id to 12 cards'indices
     */
    public void matchingAll (int[] viewIds){

        //check if viewIds is invalid or empty
        if (viewIds == null || viewIds.length == 0){
            System.out.println ("viewIds is invalid or empty");
            return;
        }

        int count = Math.min(viewIds.length, NUM_OF_TABLE_CARDS);
        for (int i = 0; i < count; i++) {
            mViewIdsToCardIndices.put(viewIds[i], i);
        }
    }

    public Card getCardFromViewId (int viewId){
        Card card = null;
        Integer index = mViewIdsToCardIndices.get(viewId);
        if (isValidIndex(index)){
            card = mCards[index];
        }
        return card;
    }

    /**matchingElements method match viewIds of refilled cards
     * to selected cardElements of the deck
     */
    public void matchingElements (int[] viewIds, int[] cardPositions){
        if (viewIds == null || viewIds.length == 0 || cardPositions == null || cardPositions.length ==0){
            System.out.println ("viewIds or cardPositions is empty");
            return;
        }

        if (viewIds.length != cardPositions.length){
            System.out.println("viewIds and cardPositions are not the same size");
            return;
        }

        for (int i = 0; i < viewIds.length ; i++) {
            mViewIdsToCardIndices.put(viewIds[i], cardPositions[i]);
        }
    }

    public int[] getEmptyCardPositions(){
        int size = mEmptyPositions.size();

        int[] emptyPos = new int[size];
        Iterator<Integer> iterator = mEmptyPositions.iterator();
        for (int i = 0; i < size; i++) {
            emptyPos[i] = iterator.next();
        }
        return emptyPos;
    }

    public void removeCardsByViewIds(Set<Integer> viewIds) {
        if (null == viewIds || viewIds.isEmpty()) {
            return ;
        }
        for (Integer viewId : viewIds) {
            remove(mViewIdsToCardIndices.get(viewId));
        }
    }

    public void resetCardStatusInTable(){
        for (int i = 0; i < NUM_OF_TABLE_CARDS; i++) {
            mCards[i].setStatus(Card.CARD_NOT_IN_TABLE);
        }
    }
}