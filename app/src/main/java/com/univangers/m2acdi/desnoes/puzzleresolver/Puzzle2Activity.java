package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapter;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.PageAdapter;

import java.util.Map;

public class Puzzle2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle2);
        setTitle("Movie Buffs Associated - Al Pacino");

        configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs(){
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), 2));

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

        if(!comparaisonResultatEtResultatCourant(DataResultat.currentRes, DataResultat.RES_PUZZLE2)) {
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

    private boolean comparaisonResultatEtResultatCourant(Map<String, Map<String, String>> currentRes, Map<String, Map<String, String>> res) {
        for(Map.Entry entry : res.entrySet()) {
            Map<String, String> mapKey = (Map<String, String>) entry.getValue();
            for(Map.Entry keyEntry : mapKey.entrySet()) {

                String strRes = currentRes.get(entry.getKey()).get(keyEntry.getKey());
                if(keyEntry.getValue() != null && strRes != null) {
                    if (!keyEntry.getValue().toString().trim().toLowerCase().equals(strRes.trim().toLowerCase())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
