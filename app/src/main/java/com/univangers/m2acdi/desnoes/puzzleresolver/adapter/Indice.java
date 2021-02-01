package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

public class Indice {

    private boolean used;
    private String text;


    public Indice(String text, boolean used) {
        this.used = used;
        this.text = text;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
