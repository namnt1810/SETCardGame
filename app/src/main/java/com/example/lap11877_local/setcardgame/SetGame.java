package com.example.lap11877_local.setcardgame;

public class SetGame {

    private Deck mDeck;

    private GameTable mTable;

    public SetGame(){
        mDeck = new Deck();
        mTable = new GameTable(mDeck.makeTable());
    }

    public void matchingViewIds (int[] viewIds){
        mTable.matchingAll(viewIds);
    }

    public GameTable getTable(){
        return mTable;
    }

    public Card getSelectedCard (int viewId){
        return mTable.getCardFromViewId(viewId);
    }

    public boolean isSet (Card card1, Card card2, Card card3){
        return colorMatch(card1, card2, card3) && countMatch(card1, card2, card3)
                && shadingMatch(card1, card2, card3) && shapeMatch(card1, card2, card3);
    }

    public boolean colorMatch (Card card1, Card card2, Card card3){
        Features.Color color1 = card1.getColor();
        Features.Color color2 = card2.getColor();
        Features.Color color3 = card3.getColor();

        if (color1.equals(color2) && color2.equals(color3)){
            return true;
        }
        if (!color1.equals(color2) && !color2.equals(color3) && !color3.equals(color1)){
            return true;
        }
        return false;
    }

    public boolean countMatch (Card card1, Card card2, Card card3){
        Features.Count count1 = card1.getCount();
        Features.Count count2 = card2.getCount();
        Features.Count count3 = card3.getCount();

        if (count1.equals(count2) && count2.equals(count3)){
            return true;
        }
        if (!count1.equals(count2) && !count2.equals(count3) && !count3.equals(count1)){
            return true;
        }
        return false;
    }

    public boolean shadingMatch (Card card1, Card card2, Card card3){
        Features.Shading shading1 = card1.getShading();
        Features.Shading shading2 = card2.getShading();
        Features.Shading shading3 = card3.getShading();

        if (shading1.equals(shading2) && shading2.equals(shading3)){
            return true;
        }
        if (!shading1.equals(shading2) && !shading2.equals(shading3) && !shading3.equals(shading1)){
            return true;
        }
        return false;
    }

    public boolean shapeMatch (Card card1, Card card2, Card card3){
        Features.Shape shape1 = card1.getShape();
        Features.Shape shape2 = card2.getShape();
        Features.Shape shape3 = card3.getShape();

        if (shape1.equals(shape2) && shape2.equals(shape3)){
            return true;
        }
        if (!shape1.equals(shape2) && !shape2.equals(shape3) && !shape3.equals(shape1)){
            return true;
        }
        return false;
    }

    public Card[] generateNextCards() {
        return mDeck.generateCards(3);
    }

    public Card[] shuffleTable(){
        return mDeck.generateCards(12);
    }

    public void setTable(GameTable mTable) {
        this.mTable = mTable;
    }
}