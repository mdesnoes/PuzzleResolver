package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.util.Log;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class DataResultat {

    public static final Map<String, Coordonnee> RES_PUZZLE1 = new LinkedHashMap<String,Coordonnee>() {{

        // Colors
        put("yellow", new Coordonnee(1,1));
        put("blue", new Coordonnee(2,1));
        put("red", new Coordonnee(3,1));
        put("white", new Coordonnee(4,1));
        put("green", new Coordonnee(5,1));

        // Surname
        put("Victoria", new Coordonnee(1,2));
        put("Leslie", new Coordonnee(2,2));
        put("Andrea", new Coordonnee(3,2));
        put("Julie", new Coordonnee(4,2));
        put("Holly", new Coordonnee(5,2));

        // Name
        put("Davis", new Coordonnee(1,3));
        put("Miller", new Coordonnee(2,3));
        put("Brown", new Coordonnee(3,3));
        put("Wilson", new Coordonnee(4,3));
        put("Lopes", new Coordonnee(5,3));

        // Pasta
        put("ravioli", new Coordonnee(1,4));
        put("farfalle", new Coordonnee(2,4));
        put("penne", new Coordonnee(3,4));
        put("lasagne", new Coordonnee(4,4));
        put("spaghetti", new Coordonnee(5,4));

        // Wine
        put("argentine", new Coordonnee(1,5));
        put("chilean", new Coordonnee(2,5));
        put("italian", new Coordonnee(3,5));
        put("australian", new Coordonnee(4,5));
        put("french", new Coordonnee(5,5));

        // Age
        put("50", new Coordonnee(1,6));
        put("35", new Coordonnee(2,6));
        put("30", new Coordonnee(3,6));
        put("40", new Coordonnee(4,6));
        put("45", new Coordonnee(5,6));

    }};

    public static final Map<String, Map<String, String>> RES_PUZZLE2 = new LinkedHashMap<String, Map<String, String>>() {{
        put("Jessica", new LinkedHashMap<String, String>() {{
            put("film", "Donnie Brasco");
            put("jour", "Wednesday");
            put("temps", "8:30 pm");
        }});
        put("Laurie", new LinkedHashMap<String, String>() {{
            put("film", "The Recruit");
            put("jour", "Friday");
            put("temps", "7:35 pm");
        }});
        put("Mark", new LinkedHashMap<String, String>() {{
            put("film", "Scarecrow");
            put("jour", "Tuesday");
            put("temps", "8:45 pm");
        }});
        put("Mary", new LinkedHashMap<String, String>() {{
            put("film", "88 Minutes");
            put("jour", "Monday");
            put("temps", "8:20 pm");
        }});
        put("Sally", new LinkedHashMap<String, String>() {{
            put("film", "Scarface");
            put("jour", "Thursday");
            put("temps", "7:40 pm");
        }});
    }};


    public static final Map<String, Map<String, String>> RES_PUZZLE3 = new LinkedHashMap<String, Map<String, String>>() {{
        put("13'", new LinkedHashMap<String, String>() {{
            put("proc.", "2.0 MHz");
            put("dd", "320 Gb");
            put("prix", "$ 999.00");
        }});
        put("15'", new LinkedHashMap<String, String>() {{
            put("proc.", "2.3 MHz");
            put("dd", "250 Gb");
            put("prix", "$ 699.00");
        }});
        put("15.6'", new LinkedHashMap<String, String>() {{
            put("proc.", "2.5 MHz");
            put("dd", "500 Gb");
            put("prix", "$ 1 349.00");
        }});
        put("21.5'", new LinkedHashMap<String, String>() {{
            put("proc.", "2.7 MHz");
            put("dd", "1024 Gb");
            put("prix", "$ 1 149.00");
        }});
        put("27'", new LinkedHashMap<String, String>() {{
            put("proc.", "3.1 MHz");
            put("dd", "750 Gb");
            put("prix", "$ 1 649.00");
        }});
    }};

    // Le resultat courant, il est modifié dynamiquement
    public static Map<String, Map<String, String>> currentRes = new LinkedHashMap<>();

    public static void initResultatVide(List<String> keys) {
        currentRes.clear();
        for(String str : keys) {
            currentRes.put(str, new LinkedHashMap<>());
        }
    }

    public static void updateResultat(String key, String keyVal, String data) {
        for(Map.Entry map : currentRes.entrySet()) {
            if(map.getKey().equals(key)) {
                ((Map<String, String>) map.getValue()).put(keyVal, data);
            }
        }
    }

    public static String getResultat(String key, String keyVal) {
        return currentRes.get(key).get(keyVal);
    }

    // Le resultat courant, il est modifié dynamiquement
    public static Map<String, Coordonnee> currentResPuzzle1 = new LinkedHashMap<>();

    public static void initResultatVidePuzzle1() {
        currentResPuzzle1.clear();
        for(int i = 0; i<36; i++) {
            currentResPuzzle1.put("", new Coordonnee(0,0));
        }
    }

    public static void updateResultatPuzzle1 (String key, Coordonnee coordVal) {
        String aSupp = "";
        for(Map.Entry<String, Coordonnee> entry : currentResPuzzle1.entrySet()) {
            String k = entry.getKey();
            Coordonnee v = entry.getValue();
            if(v.getX() == coordVal.getX() && v.getY() == coordVal.getY()){
                aSupp = k;
            }
        }
        currentResPuzzle1.remove(aSupp);
        currentResPuzzle1.put(key, coordVal);
    }

    public static Coordonnee getResultatPuzzle1 (String key) {
        if(currentResPuzzle1.containsKey(key)){
            return currentResPuzzle1.get(key);
        } else {
            return new Coordonnee(0,0);
        }

    }
}
