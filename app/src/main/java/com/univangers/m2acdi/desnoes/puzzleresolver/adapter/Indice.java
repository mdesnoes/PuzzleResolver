package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

import com.univangers.m2acdi.desnoes.puzzleresolver.EtatIndice;

public class Indice {

    private EtatIndice etatIndice;
    private String text;


    public Indice(String text, EtatIndice etatIndice) {
        this.etatIndice = etatIndice;
        this.text = text;
    }

    public EtatIndice getEtatIndice() {
        return etatIndice;
    }

    public void setEtatIndice(EtatIndice etatIndice) {
        this.etatIndice = etatIndice;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
