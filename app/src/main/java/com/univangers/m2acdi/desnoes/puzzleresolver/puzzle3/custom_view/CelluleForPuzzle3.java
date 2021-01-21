package com.univangers.m2acdi.desnoes.puzzleresolver.puzzle3.custom_view;

import com.univangers.m2acdi.desnoes.puzzleresolver.ColorCellule;

public class CelluleForPuzzle3 {

    private ColorCellule color;

    private String valLigne;
    private String valColonne;

    private float left;
    private float top;
    private float right;
    private float bottom;


    public CelluleForPuzzle3(float left, float top, float right, float bottom, String valLigne, String valColonne) {
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
            this.color = ColorCellule.GREEN;
        } else if(this.color == ColorCellule.GREEN) {
            this.color = ColorCellule.RED;
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
