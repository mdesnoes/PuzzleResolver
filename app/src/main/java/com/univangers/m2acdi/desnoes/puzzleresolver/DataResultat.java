package com.univangers.m2acdi.desnoes.puzzleresolver;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataResultat {

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

}
