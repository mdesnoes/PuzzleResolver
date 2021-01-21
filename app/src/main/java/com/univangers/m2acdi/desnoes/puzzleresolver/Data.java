package com.univangers.m2acdi.desnoes.puzzleresolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Data {

    // Données pour le Puzzle 2
    public final static List<String> TAB_FILM = new ArrayList<String>(Arrays.asList("88 Minutes", "Donnie Brasco", "Scarecrow", "Scarface", "The recruit"));
    public final static List<String> TAB_JOUR = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"));
    public final static List<String> TAB_TEMPS = new ArrayList<String>(Arrays.asList("7:35 pm", "7:40 pm", "8:20 pm", "8:30 pm", "8:45 pm"));
    public final static List<String> TAB_NOM = new ArrayList<String>(Arrays.asList("Jessica", "Laurie", "Mark", "Mary", "Sally"));

    public final static List<String> TAB_INDICE_PUZZLE2 = new ArrayList<String>(Arrays.asList(
            "1. Of the 20-hundreds releases, neither of which was Jessica's choice, one opened the week and one closed the week.",
            "2. The latest of the 19-hundreds releases was shown at 30 minutes past the hour.",
            "3. The releases shown before 8:00 pm were on consecutive days, as were the releases shown after 8:00 pm.",
            "4. One of the men and one of the women had a showing before 8:00 pm, but neither was mid-week.",
            "5. Mark, whose choice was Scarecrow, had a showing at a time of one hour and five minutes after that of Scarface.",
            "6. Neither Miss Farmer nor Miss Peters had a showing on an even-numbered day",
            "7. 88 Minutes showed at a time both 40 minutes to the hour and 40 minutes after the Thursday showing."));
    public final static List<String> TAB_RESULTAT_PUZZLE2 = new ArrayList<String>(Arrays.asList("Nom", "Film", "Jour", "Temps"));


    // Données pour le Puzzle 3
    public final static List<String> TAB_PROCESSEUR = new ArrayList<String>(Arrays.asList("2.0 MHz", "2.3 MHz", "2.5 MHz", "2.7 MHz", "3.1 MHz"));
    public final static List<String> TAB_DISQUEDUR = new ArrayList<String>(Arrays.asList("250 Gb", "320 Gb", "500 Gb", "750 Gb", "1024 Gb"));
    public final static List<String> TAB_PRIX = new ArrayList<String>(Arrays.asList("$ 699.00", "$ 999.00", "$ 1 149.00", "$ 1 349.00", "$ 1 649.00"));
    public final static List<String> TAB_ECRAN = new ArrayList<String>(Arrays.asList("13'", "15'", "15.6'", "21.5'", "27'"));

    public final static List<String> TAB_INDICE_PUZZLE3 = new ArrayList<String>(Arrays.asList(
            "1. Andrew bought the computer which was three hundred Euros less than the PC which has a processor that is 0.4 MHz more powerful than the one which has a 21.5' screen.",
            "2. The five computers aren: the one chosen by Andrew (which doesn't have the 27' screen), the one which has the 2.0-MHz processor, the computer that has a 250 GB HD, the one which has a price of 1,149 Euros and the computer (which doesn't have the 15' screen) that has the HD bigger than the one chosen by Andrew but smaller than that the one which has the 2.7 MHz processor.",
            "3. The computer with the 320 Gb HD has either the 2.0 or the 2.3 MHz processor.The processor of the computer which has the 15' screen is more powerful than the one in the computer that costs 999 euros but less powerful than the processor that is included in the 1,349 Euros computer.",
            "4. The computer that has the 27' screen doesn't have the 320 Gb hard drive. The 500 GB HD is included in the computer that has a more powerful professor and a larger size screen than the one which costs 699 euros (which doesn't include the 320 Gb HD)."));
    public final static List<String> TAB_RESULTAT_PUZZLE3 = new ArrayList<String>(Arrays.asList("Ecran", "Proc.", " DD ", "Prix"));


    public static final List<String> getTableauValeursByNomAttribut(String att) {
        switch(att.toUpperCase()) {
            case "FILM": return TAB_FILM;
            case "JOUR": return TAB_JOUR;
            case "TEMPS": return TAB_TEMPS;
            case "NOM": return  TAB_NOM;
            case "PROCESSEUR": return TAB_PROCESSEUR;
            case "DISQUEDUR": return TAB_DISQUEDUR;
            case "PRIX": return TAB_PRIX;
            case "ECRAN": return  TAB_ECRAN;
            default: return null;
        }
    }

}
