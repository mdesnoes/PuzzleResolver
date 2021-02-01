package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.univangers.m2acdi.desnoes.puzzleresolver.Coordonnee;
import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.DataResultat;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ConfigPuzzle1 {

    private final HashMap<Boolean, Coordonnee> mapReponse = new LinkedHashMap<>();

    private static final String COLOR = "color";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PASTA = "pasta";
    private static final String WINE = "wine";
    private static final String AGE = "age";

    private static List<Spinner> listColorsSp = new ArrayList<>();
    private static List<Spinner> listNameSp = new ArrayList<>();
    private static List<Spinner> listSurnameSp = new ArrayList<>();
    private static List<Spinner> listPastaSp = new ArrayList<>();
    private static List<Spinner> listWineSp = new ArrayList<>();
    private static List<Spinner> listAgeSp = new ArrayList<>();

    public View makeConfigurationPuzzle1(View view){
        createSpinners(view);
        addElementsToSpinners(view);
        onPurchase(view);
        return view;
    }

    public static void onPurchase(View view){
        onSelectedSpin(view.findViewById(R.id.sp_1_1), 1 ,1);
        onSelectedSpin(view.findViewById(R.id.sp_1_2), 1 ,2);
        onSelectedSpin(view.findViewById(R.id.sp_1_3), 1 ,3);
        onSelectedSpin(view.findViewById(R.id.sp_1_4), 1 ,4);
        onSelectedSpin(view.findViewById(R.id.sp_1_5), 1 ,5);
        onSelectedSpin(view.findViewById(R.id.sp_1_6), 1 ,6);

        onSelectedSpin(view.findViewById(R.id.sp_2_1), 2 ,1);
        onSelectedSpin(view.findViewById(R.id.sp_2_2), 2 ,2);
        onSelectedSpin(view.findViewById(R.id.sp_2_3), 2 ,3);
        onSelectedSpin(view.findViewById(R.id.sp_2_4), 2 ,4);
        onSelectedSpin(view.findViewById(R.id.sp_2_5), 2 ,5);
        onSelectedSpin(view.findViewById(R.id.sp_2_6), 2 ,6);

        onSelectedSpin(view.findViewById(R.id.sp_3_1), 3 ,1);
        onSelectedSpin(view.findViewById(R.id.sp_3_2), 3 ,2);
        onSelectedSpin(view.findViewById(R.id.sp_3_3), 3 ,3);
        onSelectedSpin(view.findViewById(R.id.sp_3_4), 3 ,4);
        onSelectedSpin(view.findViewById(R.id.sp_3_5), 3 ,5);
        onSelectedSpin(view.findViewById(R.id.sp_3_6), 3 ,6);

        onSelectedSpin(view.findViewById(R.id.sp_4_1), 4 ,1);
        onSelectedSpin(view.findViewById(R.id.sp_4_2), 4 ,2);
        onSelectedSpin(view.findViewById(R.id.sp_4_3), 4 ,3);
        onSelectedSpin(view.findViewById(R.id.sp_4_4), 4 ,4);
        onSelectedSpin(view.findViewById(R.id.sp_4_5), 4 ,5);
        onSelectedSpin(view.findViewById(R.id.sp_4_6), 4 ,6);

        onSelectedSpin(view.findViewById(R.id.sp_5_1), 5 ,1);
        onSelectedSpin(view.findViewById(R.id.sp_5_2), 5, 2);
        onSelectedSpin(view.findViewById(R.id.sp_5_3), 5 ,3);
        onSelectedSpin(view.findViewById(R.id.sp_5_4), 5 ,4);
        onSelectedSpin(view.findViewById(R.id.sp_5_5), 5 ,5);
        onSelectedSpin(view.findViewById(R.id.sp_5_6), 5 ,6);

    }

    public static void onSelectedSpin(Spinner spin, int x, int y){
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> aParentView,
                                       View aView, int aPosition, long anId) {
                DataResultat.updateResultatPuzzle1(aParentView.getSelectedItem().toString(), new Coordonnee(x,y));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    /**
     * Ajout dans les listes déroulantes des élément la constituant
     */
    public void addElementsToSpinners(View view){
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
    public void initSpinner(Spinner spinner, String famille, View view){

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
                Log.e("TAG", "Famille non reconnue !");
        }

    }



    /**
     * Créations et récupération des spinner depuis la vue de pasta and wine, puis ajout dans les listes correspondantes
     * @param view
     */
    public void createSpinners(View view){
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

    public static boolean confirmIndice(int indice){
        switch(indice){
            case 0 :
                int colIta = DataResultat.getResultatPuzzle1("italian").getX();
                int colWhite = DataResultat.getResultatPuzzle1("white").getX();
                return colIta - colWhite == 1 || colIta - colWhite == -1;

            case 1 :
                int colDavis = DataResultat.getResultatPuzzle1("Davis").getX();
                int colMiller = DataResultat.getResultatPuzzle1("Miller").getX();
                int colBrown = DataResultat.getResultatPuzzle1("Brown").getX();
                return colDavis < colMiller && colMiller < colBrown;

            case 2 :
                int col30 = DataResultat.getResultatPuzzle1("30").getX();
                return col30 == 3;

            case 3 :
                int col45 = DataResultat.getResultatPuzzle1("45").getX();
                int colRed = DataResultat.getResultatPuzzle1("red").getX();
                return col45 > colRed;

            case 4 :
                int colFarf = DataResultat.getResultatPuzzle1("farfalle").getX();
                int colChil = DataResultat.getResultatPuzzle1("chilean").getX();
                return colFarf != 0 && colChil != 0 &&  colFarf == colChil;

            case 5 :
                int colArg = DataResultat.getResultatPuzzle1("argentine").getX();
                return colArg == 1;

            case 6 :
                int colAndre = DataResultat.getResultatPuzzle1("Andrea").getX();
                int col35_2 = DataResultat.getResultatPuzzle1("35").getX();
                return colAndre - col35_2 == 1;

            case 7 :
                int colDavis_2 = DataResultat.getResultatPuzzle1("Davis").getX();
                int colBlue = DataResultat.getResultatPuzzle1("blue").getX();
                int colHoll = DataResultat.getResultatPuzzle1("Holly").getX();
                return colDavis_2 < colBlue && colDavis_2 < colHoll;

            case 8 :
                int colVict = DataResultat.getResultatPuzzle1("Victoria").getX();
                int colLeslie = DataResultat.getResultatPuzzle1("Leslie").getX();
                return colVict - colLeslie == 1 || colVict - colLeslie == -1;

            case 9 :
                int colRed_2 = DataResultat.getResultatPuzzle1("red").getX();
                int colAustr = DataResultat.getResultatPuzzle1("australian").getX();
                return colRed_2 < colAustr;

            case 10 :
                int colWils = DataResultat.getResultatPuzzle1("Wilson").getX();
                int col30_5 = DataResultat.getResultatPuzzle1("30").getX();
                return colWils - col30_5 == 1 || colWils - col30_5 == -1;

            case 11 :
                int colLesl = DataResultat.getResultatPuzzle1("Leslie").getX();
                int col30_2 = DataResultat.getResultatPuzzle1("30").getX();
                return col30_2 - colLesl == 1;

            case 12 :
                int colHolly = DataResultat.getResultatPuzzle1("Holly").getX();
                int colRed_3 = DataResultat.getResultatPuzzle1("red").getX();
                return colHolly > colRed_3;


            case 13 :
                int colBrown_2 = DataResultat.getResultatPuzzle1("Brown").getX();
                int colJulie = DataResultat.getResultatPuzzle1("Julie").getX();
                return colBrown_2 - colJulie == -1;

            case 14 :
                int colPenne = DataResultat.getResultatPuzzle1("penne").getX();
                int col30_3 = DataResultat.getResultatPuzzle1("30").getX();
                return colPenne != 0 && colPenne != 0 && colPenne == col30_3;

            case 15 :
                int colWils_2 = DataResultat.getResultatPuzzle1("Wilson").getX();
                int colWhite_2 = DataResultat.getResultatPuzzle1("white").getX();
                return  colWils_2 != 0 && colWhite_2 != 0 && colWils_2 == colWhite_2;

            case 16 :
                int colIta_2 = DataResultat.getResultatPuzzle1("italian").getX();
                int colLasag = DataResultat.getResultatPuzzle1("lasagne").getX();
                int colSpag = DataResultat.getResultatPuzzle1("spaghetti").getX();
                return colIta_2 < colLasag && colIta_2 < colSpag;

            case 17 :
                int colBlue_2 = DataResultat.getResultatPuzzle1("blue").getX();
                return colBlue_2 == 2;

            case 18 :
                int colLasagn = DataResultat.getResultatPuzzle1("lasagne").getX();
                int col40 = DataResultat.getResultatPuzzle1("40").getX();
                return colLasagn != 0 && col40 != 0 && colLasagn == col40;
            case 19 :
                int colLopes = DataResultat.getResultatPuzzle1("Lopes").getX();
                return colLopes == 5;

            case 20 :
                int colVicto = DataResultat.getResultatPuzzle1("Victoria").getX();
                int colAustr_2 = DataResultat.getResultatPuzzle1("australian").getX();
                int colFrench = DataResultat.getResultatPuzzle1("french").getX();
                return colVicto < colAustr_2 && colAustr_2 < colFrench;

            case 21 :
                int colYello = DataResultat.getResultatPuzzle1("yellow").getX();
                int col35_3 = DataResultat.getResultatPuzzle1("35").getX();
                return col35_3 - colYello == 1;

            default : return false;

        }

    }
}
