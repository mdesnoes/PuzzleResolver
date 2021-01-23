package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import java.util.ArrayList;
import java.util.List;

public class ConfigPuzzle1 {

    private static final String COLOR = "color";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PASTA = "pasta";
    private static final String WINE = "wine";
    private static final String AGE = "age";

    Fragment fragment;
    private static List<Spinner> listColorsSp = new ArrayList<>();
    private static List<Spinner> listNameSp = new ArrayList<>();
    private static List<Spinner> listSurnameSp = new ArrayList<>();
    private static List<Spinner> listPastaSp = new ArrayList<>();
    private static List<Spinner> listWineSp = new ArrayList<>();
    private static List<Spinner> listAgeSp = new ArrayList<>();

    public static View configPuzzle1(View view){
        createSpinners(view);
        addElementsToSpinners(view);
        return view;
    }

    /**
     * Ajout dans les listes déroulantes des élément la constituant
     */
    public static void addElementsToSpinners(View view){
        listColorsSp.stream().forEach(spinner -> initSpinner(spinner, COLOR, view));
        listNameSp.stream().forEach(spinner -> initSpinner(spinner, NAME, view));
        listSurnameSp.stream().forEach(spinner -> initSpinner(spinner, SURNAME, view));
        listPastaSp.stream().forEach(spinner -> initSpinner(spinner, PASTA, view));
        listWineSp.stream().forEach(spinner -> initSpinner(spinner, WINE, view));
        listAgeSp.stream().forEach(spinner -> initSpinner(spinner, AGE, view));
    }

    /**
     * Gonflement des listes de spinners
     * @param spinner
     * @param famille
     */
    public static void initSpinner(Spinner spinner, String famille, View view){

        switch(famille){
            case COLOR :
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.COLORS));
                break;
            case NAME :
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.NAMES));
                break;
            case SURNAME :
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.SURNAMES));
                break;
            case PASTA :
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.PASTAS));
                break;
            case WINE :
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.WINES));
                break;
            case AGE:
                spinner.setAdapter(new ArrayAdapter(view.getContext(), android.R.layout.simple_spinner_item, Data.AGES));
                break;
            default :
                Log.e("TAG", "Famille nom reconnue !");
        }


    }


    /**
     * Créations et récupération des spinner depuis la vue de pasta and wine, puis ajout dans les listes correspondantes
     */
    public static void createSpinners(View view){
        // On récupère les spinner des couleurs
        listColorsSp.add(view.findViewById(R.id.sp_1_1));
        listColorsSp.add(view.findViewById(R.id.sp_2_1));
        listColorsSp.add(view.findViewById(R.id.sp_3_1));
        listColorsSp.add(view.findViewById(R.id.sp_4_1));
        listColorsSp.add(view.findViewById(R.id.sp_5_1));

        // On récupère les spinner des noms
        listNameSp.add(view.findViewById(R.id.sp_1_2));
        listNameSp.add(view.findViewById(R.id.sp_2_2));
        listNameSp.add(view.findViewById(R.id.sp_3_2));
        listNameSp.add(view.findViewById(R.id.sp_4_2));
        listNameSp.add(view.findViewById(R.id.sp_5_2));

        // On récupère les spinner des prénoms
        listSurnameSp.add(view.findViewById(R.id.sp_1_3));
        listSurnameSp.add(view.findViewById(R.id.sp_2_3));
        listSurnameSp.add(view.findViewById(R.id.sp_3_3));
        listSurnameSp.add(view.findViewById(R.id.sp_4_3));
        listSurnameSp.add(view.findViewById(R.id.sp_5_3));

        // On récupère les spinner des pates
        listPastaSp.add(view.findViewById(R.id.sp_1_4));
        listPastaSp.add(view.findViewById(R.id.sp_2_4));
        listPastaSp.add(view.findViewById(R.id.sp_3_4));
        listPastaSp.add(view.findViewById(R.id.sp_4_4));
        listPastaSp.add(view.findViewById(R.id.sp_5_4));

        // On récupère les spinner des vins
        listWineSp.add(view.findViewById(R.id.sp_1_5));
        listWineSp.add(view.findViewById(R.id.sp_2_5));
        listWineSp.add(view.findViewById(R.id.sp_3_5));
        listWineSp.add(view.findViewById(R.id.sp_4_5));
        listWineSp.add(view.findViewById(R.id.sp_5_5));

        // On récupère les spinner des ages
        listAgeSp.add(view.findViewById(R.id.sp_1_6));
        listAgeSp.add(view.findViewById(R.id.sp_2_6));
        listAgeSp.add(view.findViewById(R.id.sp_3_6));
        listAgeSp.add(view.findViewById(R.id.sp_4_6));
        listAgeSp.add(view.findViewById(R.id.sp_5_6));
    }
}
