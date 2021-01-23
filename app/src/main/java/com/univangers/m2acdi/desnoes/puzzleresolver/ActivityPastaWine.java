package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ActivityPastaWine extends AppCompatActivity {
    
    private static final String TAG = "ActivityPastaWine";

    private PastaWineData pastaWineData = new PastaWineData();
    
    private static final String COLOR = "color";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String PASTA = "pasta";
    private static final String WINE = "wine";
    private static final String AGE = "age";

    private List<Spinner> listColorsSp = new ArrayList<>();
    private List<Spinner> listNameSp = new ArrayList<>();
    private List<Spinner> listSurnameSp = new ArrayList<>();
    private List<Spinner> listPastaSp = new ArrayList<>();
    private List<Spinner> listWineSp = new ArrayList<>();
    private List<Spinner> listAgeSp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atcivity_pasta_wine);

        createSpinners();
        addElementsToSpinners();
    }

    /**
     * Ajout dans les listes déroulantes des élément la constituant
     */
    public void addElementsToSpinners(){
        listColorsSp.stream().forEach(spinner -> initSpinner(spinner, COLOR));
        listNameSp.stream().forEach(spinner -> initSpinner(spinner, NAME));
        listSurnameSp.stream().forEach(spinner -> initSpinner(spinner, SURNAME));
        listPastaSp.stream().forEach(spinner -> initSpinner(spinner, PASTA));
        listWineSp.stream().forEach(spinner -> initSpinner(spinner, WINE));
        listAgeSp.stream().forEach(spinner -> initSpinner(spinner, AGE));
    }

    /**
     * Gonflement des listes de spinners
     * @param spinner
     * @param famille
     */
    public void initSpinner(Spinner spinner, String famille){

        switch(famille){
            case COLOR :
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.COLORS));
                break;
            case NAME :
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.NAMES));
                break;
            case SURNAME :
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.SURNAMES));
                break;
            case PASTA :
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.PASTAS));
                break;
            case WINE :
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.WINES));
                break;
            case AGE:
                spinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, pastaWineData.AGES));
                break;
            default :
                Log.e(TAG, "Famille nom reconnue !");
        }

        
    }
    

    /**
     * Créations et récupération des spinner depuis la vue de pasta and wine, puis ajout dans les listes correspondantes
     */
    public void createSpinners(){
        // On récupère les spinner des couleurs
        listColorsSp.add(findViewById(R.id.sp_1_1));
        listColorsSp.add(findViewById(R.id.sp_2_1));
        listColorsSp.add(findViewById(R.id.sp_3_1));
        listColorsSp.add(findViewById(R.id.sp_4_1));
        listColorsSp.add(findViewById(R.id.sp_5_1));

        // On récupère les spinner des noms
        listNameSp.add(findViewById(R.id.sp_1_2));
        listNameSp.add(findViewById(R.id.sp_2_2));
        listNameSp.add(findViewById(R.id.sp_3_2));
        listNameSp.add(findViewById(R.id.sp_4_2));
        listNameSp.add(findViewById(R.id.sp_5_2));

        // On récupère les spinner des prénoms
        listSurnameSp.add(findViewById(R.id.sp_1_3));
        listSurnameSp.add(findViewById(R.id.sp_2_3));
        listSurnameSp.add(findViewById(R.id.sp_3_3));
        listSurnameSp.add(findViewById(R.id.sp_4_3));
        listSurnameSp.add(findViewById(R.id.sp_5_3));

        // On récupère les spinner des pates
        listPastaSp.add(findViewById(R.id.sp_1_4));
        listPastaSp.add(findViewById(R.id.sp_2_4));
        listPastaSp.add(findViewById(R.id.sp_3_4));
        listPastaSp.add(findViewById(R.id.sp_4_4));
        listPastaSp.add(findViewById(R.id.sp_5_4));

        // On récupère les spinner des vins
        listWineSp.add(findViewById(R.id.sp_1_5));
        listWineSp.add(findViewById(R.id.sp_2_5));
        listWineSp.add(findViewById(R.id.sp_3_5));
        listWineSp.add(findViewById(R.id.sp_4_5));
        listWineSp.add(findViewById(R.id.sp_5_5));

        // On récupère les spinner des ages
        listAgeSp.add(findViewById(R.id.sp_1_6));
        listAgeSp.add(findViewById(R.id.sp_2_6));
        listAgeSp.add(findViewById(R.id.sp_3_6));
        listAgeSp.add(findViewById(R.id.sp_4_6));
        listAgeSp.add(findViewById(R.id.sp_5_6));
    }
}
