package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.PageAdapter;

import java.util.ArrayList;
import java.util.List;

public class Puzzle1Activity extends AppCompatActivity {
    
    private static final String TAG = "ActivityPastaWine";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle1);


        configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs(){
        ViewPager pager = (ViewPager) findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapter(getSupportFragmentManager(), 1));

        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }

}
