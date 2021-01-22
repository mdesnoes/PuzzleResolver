package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import com.univangers.m2acdi.desnoes.puzzleresolver.ColorCellule;

public class Cellule {

    private ColorCellule color;

    private String valLigne;
    private String valColonne;

    private float left;
    private float top;
    private float right;
    private float bottom;


    public Cellule(float left, float top, float right, float bottom, String valLigne, String valColonne) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        this.valLigne = valLigne;
        this.valColonne = valColonne;
        this.color = ColorCellule.WHITE;
    }

    public void changeColor() {
        if(this.color == ColorCellule.WHITE) {
            this.color = ColorCellule.RED;
        } else if(this.color == ColorCellule.RED) {
            this.color = ColorCellule.GREEN;
        } else {
            this.color = ColorCellule.WHITE;
        }
    }

    public ColorCellule getColor() {
        return color;
    }

    public float getLeft() {
        return left;
    }

    public float getTop() {
        return top;
    }

    public float getRight() {
        return right;
    }

    public float getBottom() {
        return bottom;
    }

    public String getValLigne() {
        return valLigne;
    }

    public String getValColonne() {
        return valColonne;
    }
}
