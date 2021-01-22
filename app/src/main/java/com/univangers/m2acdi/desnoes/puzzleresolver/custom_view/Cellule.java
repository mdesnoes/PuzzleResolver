package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import com.univangers.m2acdi.desnoes.puzzleresolver.EtatCellule;

public class Cellule {

    private EtatCellule etat;

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
        this.etat = EtatCellule.VIDE;
    }

    public EtatCellule getEtat() {
        return etat;
    }

    public void setEtat(EtatCellule etat) {
        this.etat = etat;
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
