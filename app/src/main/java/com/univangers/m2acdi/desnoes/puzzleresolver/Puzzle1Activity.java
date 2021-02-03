package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.PageAdapter;

import java.util.Map;

public class Puzzle1Activity extends AppCompatActivity {
    
    private static final String TAG = "ActivityPastaWine";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle1);
        setTitle("Pasta and Wine");
        DataResultat.initResultatVidePuzzle1();
        configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs(){
        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), 1));

        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

    public void onValiderResultat(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setCancelable(true)
                .setPositiveButton("Continuer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                    }
                });

        if(!comparaisonResultatEtResultatCourant(DataResultat.currentResPuzzle1, DataResultat.RES_PUZZLE1)) {
            builder.setTitle("Erreur");
            builder.setMessage("Une ou plusieurs cases sont incorrectes");
            builder.setIcon(R.drawable.ic_erreur);
        } else {
            builder.setTitle("Félicitation !");
            builder.setMessage("Vous avez réussi le puzzle");
            builder.setIcon(R.drawable.ic_victoire);
        }

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private boolean comparaisonResultatEtResultatCourant(Map<String, Coordonnee> currentRes, Map<String, Coordonnee> res) {

        for(Map.Entry entry : res.entrySet()) {Log.i("----------","Key : "+entry.getKey()+" ");
            Coordonnee coordonnee = (Coordonnee) entry.getValue();
            Coordonnee coordonneeRes = currentRes.get(entry.getKey());

            if(entry.getKey() != null && coordonneeRes != null) {
                if (coordonnee.getX() != coordonneeRes.getX() || coordonnee.getY() != coordonneeRes.getY()) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
