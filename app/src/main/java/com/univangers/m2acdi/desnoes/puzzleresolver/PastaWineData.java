package com.univangers.m2acdi.desnoes.puzzleresolver;

import java.util.ArrayList;
import java.util.List;

public class PastaWineData {

    public List<String> COLORS = new ArrayList<>();
    public List<String> NAMES = new ArrayList<>();
    public List<String> SURNAMES = new ArrayList<>();
    public List<String> PASTAS = new ArrayList<>();
    public List<String> WINES = new ArrayList<>();
    public List<String> AGES = new ArrayList<>();

    public PastaWineData(){
        COLORS.add("");
        COLORS.add("red");
        COLORS.add("white");
        COLORS.add("blue");
        COLORS.add("green");
        COLORS.add("yellow");

        NAMES.add("");
        NAMES.add("Andrea");
        NAMES.add("Holly");
        NAMES.add("Julie");
        NAMES.add("Leslie");
        NAMES.add("Victoria");

        SURNAMES.add("");
        SURNAMES.add("Brown");
        SURNAMES.add("Davis");
        SURNAMES.add("Lopez");
        SURNAMES.add("Miller");
        SURNAMES.add("Wilson");

        PASTAS.add("");
        PASTAS.add("penne");
        PASTAS.add("spaghetti");
        PASTAS.add("lasagne");
        PASTAS.add("farfalle");
        PASTAS.add("ravioli");

        WINES.add("");
        WINES.add("italian");
        WINES.add("france");
        WINES.add("australian");
        WINES.add("argentine");
        WINES.add("chilean");

        AGES.add("");
        AGES.add("30");
        AGES.add("35");
        AGES.add("40");
        AGES.add("45");
        AGES.add("50");
    }
}
