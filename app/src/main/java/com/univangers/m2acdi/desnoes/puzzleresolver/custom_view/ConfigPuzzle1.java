package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.univangers.m2acdi.desnoes.puzzleresolver.Coordonnee;
import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.DataResultat;
import com.univangers.m2acdi.desnoes.puzzleresolver.EtatIndice;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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

        if(y == 1){

            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> aParentView,
                                           View aView, int aPosition, long anId) {

                    String color = aParentView.getSelectedItem().toString();

                    if(color.equals("red")) {
                        spin.setBackgroundResource(R.drawable.spinner_style_red);
                    } else if(color.equals("white")) {
                        spin.setBackgroundResource(R.drawable.spinner_style);
                    } else if(color.equals("blue")) {
                        spin.setBackgroundResource(R.drawable.spinner_style_blue);
                    } else if(color.equals("green")) {
                        spin.setBackgroundResource(R.drawable.spinner_style_green);
                    } else if(color.equals("yellow")) {
                        spin.setBackgroundResource(R.drawable.spinner_style_yellow);
                    } else {
                        spin.setBackgroundResource(R.drawable.spinner_style);
                    }

                    DataResultat.updateResultatPuzzle1(color, new Coordonnee(x,y));

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        } else {
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

    /**
     * Permet de gérer l'état des indices
     * @param indice
     * @return
     */
    public static EtatIndice confirmIndice(int indice){
        switch(indice){
            case 0 :
                int colIta = DataResultat.getResultatPuzzle1("italian").getX();
                int colWhite = DataResultat.getResultatPuzzle1("white").getX();
                if(colIta != 0 && colWhite != 0){
                    if(colIta - colWhite == 1 || colIta - colWhite == -1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 1 :
                int colDavis = DataResultat.getResultatPuzzle1("Davis").getX();
                int colMiller = DataResultat.getResultatPuzzle1("Miller").getX();
                int colBrown = DataResultat.getResultatPuzzle1("Brown").getX();
                if(colDavis != 0 && colMiller !=0 && colBrown != 0){
                    if( colDavis < colMiller && colMiller < colBrown){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 2 :
                int col30 = DataResultat.getResultatPuzzle1("30").getX();
                if(col30 != 0){
                    if(col30 == 3){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                }else {
                    return EtatIndice.VIDE;
                }

            case 3 :
                int col45 = DataResultat.getResultatPuzzle1("45").getX();
                int colRed = DataResultat.getResultatPuzzle1("red").getX();
                if(col45 != 0 && colRed != 0) {
                    if (col45 > colRed) {
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 4 :
                int colFarf = DataResultat.getResultatPuzzle1("farfalle").getX();
                int colChil = DataResultat.getResultatPuzzle1("chilean").getX();
                if(colFarf != 0 && colChil != 0){
                    if(colChil != 0 && colFarf == colChil){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 5 :
                int colArg = DataResultat.getResultatPuzzle1("argentine").getX();
                if(colArg != 0){
                    if(colArg == 1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 6 :
                int colAndre = DataResultat.getResultatPuzzle1("Andrea").getX();
                int col35_2 = DataResultat.getResultatPuzzle1("35").getX();
                if(colAndre != 0 && col35_2 != 0){
                    if(colAndre - col35_2 == 1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 7 :
                int colDavis_2 = DataResultat.getResultatPuzzle1("Davis").getX();
                int colBlue = DataResultat.getResultatPuzzle1("blue").getX();
                int colHoll = DataResultat.getResultatPuzzle1("Holly").getX();
                if(colDavis_2 != 0 && colBlue !=0 && colHoll != 0){
                    if(colDavis_2 < colBlue && colDavis_2 < colHoll){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 8 :
                int colVict = DataResultat.getResultatPuzzle1("Victoria").getX();
                int colLeslie = DataResultat.getResultatPuzzle1("Leslie").getX();
                if(colVict != 0 && colLeslie != 0){
                    if(colVict - colLeslie == 1 || colVict - colLeslie == -1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 9 :
                int colRed_2 = DataResultat.getResultatPuzzle1("red").getX();
                int colAustr = DataResultat.getResultatPuzzle1("australian").getX();
                if(colRed_2 != 0 && colAustr != 0){
                    if(colRed_2 < colAustr){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 10 :
                int colWils = DataResultat.getResultatPuzzle1("Wilson").getX();
                int col30_5 = DataResultat.getResultatPuzzle1("30").getX();
                if(colWils != 0 && col30_5 != 0){
                    if(colWils - col30_5 == 1 || colWils - col30_5 == -1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 11 :
                int colLesl = DataResultat.getResultatPuzzle1("Leslie").getX();
                int col30_2 = DataResultat.getResultatPuzzle1("30").getX();
                if(colLesl != 0 && col30_2 != 0){
                    if(col30_2 - colLesl == 1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 12 :
                int colHolly = DataResultat.getResultatPuzzle1("Holly").getX();
                int colRed_3 = DataResultat.getResultatPuzzle1("red").getX();
                if(colHolly != 0 && colRed_3 != 0){
                    if(colHolly > colRed_3){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.VIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 13 :
                int colBrown_2 = DataResultat.getResultatPuzzle1("Brown").getX();
                int colJulie = DataResultat.getResultatPuzzle1("Julie").getX();
                if(colBrown_2 != 0 && colJulie != 0){
                    if(colBrown_2 - colJulie == -1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 14 :
                int colPenne = DataResultat.getResultatPuzzle1("penne").getX();
                int col30_3 = DataResultat.getResultatPuzzle1("30").getX();
                if(colPenne != 0 && col30_3 != 0){
                    if(colPenne == col30_3){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 15 :
                int colWils_2 = DataResultat.getResultatPuzzle1("Wilson").getX();
                int colWhite_2 = DataResultat.getResultatPuzzle1("white").getX();
                if(colWils_2 != 0 && colWhite_2 != 0){
                    if(colWhite_2 != 0 && colWils_2 == colWhite_2){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 16 :
                int colIta_2 = DataResultat.getResultatPuzzle1("italian").getX();
                int colLasag = DataResultat.getResultatPuzzle1("lasagne").getX();
                int colSpag = DataResultat.getResultatPuzzle1("spaghetti").getX();
                if(colIta_2 != 0 && colLasag != 0 && colSpag != 0){
                    if(colIta_2 < colLasag && colIta_2 < colSpag){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 17 :
                int colBlue_2 = DataResultat.getResultatPuzzle1("blue").getX();
                if(colBlue_2 != 0){
                    if(colBlue_2 == 2){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }


            case 18 :
                int colLasagn = DataResultat.getResultatPuzzle1("lasagne").getX();
                int col40 = DataResultat.getResultatPuzzle1("40").getX();
                if(colLasagn != 0 && col40 != 0){
                    if(colLasagn == col40){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 19 :
                int colLopes = DataResultat.getResultatPuzzle1("Lopes").getX();
                if(colLopes != 0){
                    if(colLopes == 5){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 20 :
                int colVicto = DataResultat.getResultatPuzzle1("Victoria").getX();
                int colAustr_2 = DataResultat.getResultatPuzzle1("australian").getX();
                int colFrench = DataResultat.getResultatPuzzle1("french").getX();
                if(colVicto != 0 && colAustr_2 != 0 && colFrench != 0){
                    if(colVicto < colAustr_2 && colAustr_2 < colFrench){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            case 21 :
                int colYello = DataResultat.getResultatPuzzle1("yellow").getX();
                int col35_3 = DataResultat.getResultatPuzzle1("35").getX();
                if(colYello != 0 && col35_3 != 0){
                    if(col35_3 - colYello == 1){
                        return EtatIndice.VALIDE;
                    } else {
                        return EtatIndice.INVALIDE;
                    }
                } else {
                    return EtatIndice.VIDE;
                }

            default : return EtatIndice.INVALIDE;

        }

    }
}
