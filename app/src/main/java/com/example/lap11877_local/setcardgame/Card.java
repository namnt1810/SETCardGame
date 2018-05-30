package com.example.lap11877_local.setcardgame;

import com.example.lap11877_local.setcardgame.Features.Color;
import com.example.lap11877_local.setcardgame.Features.Count;
import com.example.lap11877_local.setcardgame.Features.Shading;
import com.example.lap11877_local.setcardgame.Features.Shape;

public class Card {
    public static final String CARD_ID_FORMAT = "%d%d%d%d";

    public static final int CARD_IN_TABLE = 0;

    public static final int CARD_NOT_IN_TABLE = 1;

    private Count mCount;
    private Color mColor;
    private Shading mShading;
    private Shape mShape;
    private int mImageRes;
    private int mStatus;

    public Card (Count mCount, Color mColor, Shading mShading, Shape mShape){
        this.mCount = mCount;
        this.mColor = mColor;
        this.mShading = mShading;
        this.mShape = mShape;
    }

    public Count getCount() {
        return this.mCount;
    }

    public Color getColor() {
        return this.mColor;
    }

    public Shading getShading() {
        return this.mShading;
    }

    public Shape getShape() {
        return this.mShape;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("card: { ");
        sb.append("count=").append(resolveCount()).append(", ");
        sb.append("color=").append(resolveColor()).append(", ");
        sb.append("shading=").append(resolveShading()).append(", ");
        sb.append("shape=").append(resolveShape()).append(" }");
        return sb.toString();
    }

    private String resolveCount() {
        switch (mCount) {
            case ONE:
                return "ONE";
            case TWO:
                return "TWO";
            case THREE:
                return "THREE";
            default:
                return "UNKNOWN";
        }
    }

    private String resolveColor() {
        switch (mColor) {
            case RED:
                return "RED";
            case GREEN:
                return "GREEN";
            case BLUE:
                return "BLUE";
            default:
                return "UNKNOWN";
        }
    }

    private String resolveShading() {
        switch (mShading) {
            case OPEN:
                return "OPEN";
            case SOLID:
                return "SOLID";
            case STRIPED:
                return "STRIPED";
            default:
                return "UNKNOWN";
        }
    }

    private String resolveShape() {
        switch (mShape) {
            case SQUIGGLE:
                return "SQUIGGLE";

            case OVAL:
                return "OVAL";

            case DIAMOND:
                return "DIAMOND";

            default:
                return "UNKNOWN";
        }
    }

    public int getImageRes() {
        return mImageRes;
    }

    public void setImageRes(Integer imageRes) {
        if (imageRes == null){
            return;
        }
        this.mImageRes = imageRes;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }
}
