package com.univangers.m2acdi.desnoes.puzzleresolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Data {

    // Data puzzle 1
    public final static List<String> COLORS = new ArrayList<>(Arrays.asList("", "red", "white", "blue", "green", "yellow"));
    public final static List<String> NAMES = new ArrayList<>(Arrays.asList("", "Andrea", "Holly", "Julie", "Leslie", "Victoria"));
    public final static List<String> SURNAMES = new ArrayList<>(Arrays.asList("", "Brown", "Davis", "Miller", "Lopes", "Wilson"));
    public final static List<String> PASTAS = new ArrayList<>(Arrays.asList("", "penne", "spaghetti", "lasagne", "farfalle", "ravioli"));
    public final static List<String> WINES = new ArrayList<>(Arrays.asList("", "italian", "french", "australian", "argentine", "chilean"));
    public final static List<String> AGES = new ArrayList<>(Arrays.asList("", "30", "35", "40", "45", "50"));

    public final static List<String> TAB_INDICE_PUZZLE1 = new ArrayList<String>(Arrays.asList(
            "1 - The woman wearing the White shirt is next to the woman who likes Lombardian wines.",
            "2 - Ms Miller is somewhere between Ms Davis and Ms Brown, in that order.",
            "3 - The youngest woman is at the third position.",
            "4 - The 45 years old woman is somewhere to the right of the woman wearing the Red shirt.",
            "5 - The woman like Chilean wines also likes Farfalle.",
            "6 - At the first position is the woman that likes Argentine wines.",
            "7 - Andrea is exactly to the right of the 35 years old woman.",
            "8 - The woman wearing the Blue shirt is somewhere between Ms Davis and Holly, in that order.",
            "9 - Victoria is next to Leslie.",
            "10 - The woman wearing the Red shirt is somewhere to the left of the woman who likes Australian wines.",
            "11 - Ms Wilson is next to the 30 years old woman.",
            "12 - Leslie is exactly to the left of the 30 years old woman.",
            "13 - Holly is somewhere to the right of the woman wearing the Red shirt.",
            "14 - Ms Brown is exactly to the left of Julie.",
            "15 - The youngest woman likes Penne.",
            "16 - Ms Wilson is wearing the White shirt.",
            "17 - The woman who likes Lasagne is somewhere between the woman who likes Italian wines and the woman who likes Spaghetti, in that order.",
            "18 - At the second position is the woman wearing the Blue shirt.",
            "19 - The 40 years old woman likes Lasagne.",
            "20 - Ms Lopes is at the fifth position.",
            "21 - The woman that likes Australian wines is somewhere between Victoria and the woman who likes wines from Bordeaux, in that order.",
            "22 - The woman wearing the Yellow shirt is exactly to the left of the 35 years old woman."));

    public final static String TEXT_INTRO_PUZZLE1 = "Five friends are side by side planning a dinner together. Each one enjoys different kinds of pasta and wines from different countries. Figure out which pasta Holly likes the most.";

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

    public final static String TEXT_INTRO_PUZZLE2 = "A five-member panel, determined by a ballot of members of the local Movie Buffs Associated at the Annual General Meeting, select a series of movies, starring a particular actor/actress, to be shown in the Municipal Offices function room each evening from Monday to Friday. The panel of Sally Boyden, Mark Thomson, Jessica Farmer, Laurie Davison and Mary Peters were re-elected for 2015.\n" +
            "\n" +
            "Last week their choice actor/actress was Al Pacino, and the films chosen - one per member - were Scarface (1983), Scarecrow (1973), Donnie Brasco (1997), 88 Minutes (2007), and The Recruit (2003). The films chosen were not respective, and neither were they shown in that order, nor in the order in which they were released. Showing time differed each evening. From this information and the following clues, for each member, can you determine who chose which film, the day on which it was shown, and at what time?\"";


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
    public final static List<String> TAB_RESULTAT_PUZZLE3 = new ArrayList<String>(Arrays.asList("Ecran", "Proc.", "DD", "Prix"));

    public final static String TEXT_INTRO_PUZZLE3 = "Andrew has just bought one of these five different models of computers. Each computer has a different screen size, processor power, hard drive capacity and price. With the help of the clues, could you figure out which computer has been chosen by Andrew?";


    public static final List<String> getTableauValeursByNomAttribut(String att) {
        switch(att.toUpperCase()) {
            case "FILM": return TAB_FILM;
            case "JOUR": return TAB_JOUR;
            case "TEMPS": return TAB_TEMPS;
            case "NOM": return  TAB_NOM;
            case "PROC.": return TAB_PROCESSEUR;
            case "DD": return TAB_DISQUEDUR;
            case "PRIX": return TAB_PRIX;
            case "ECRAN": return  TAB_ECRAN;
            default: return null;
        }
    }

}
