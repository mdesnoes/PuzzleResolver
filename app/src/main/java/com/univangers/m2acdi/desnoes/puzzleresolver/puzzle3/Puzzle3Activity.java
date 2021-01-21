package com.univangers.m2acdi.desnoes.puzzleresolver.puzzle3;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

public class Puzzle3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle3);

        configureViewPagerAndTabs();
    }

    private void configureViewPagerAndTabs(){
        ViewPager pager = (ViewPager)findViewById(R.id.activity_main_viewpager);
        pager.setAdapter(new PageAdapterForPuzzle3(getSupportFragmentManager()));

        TabLayout tabs= (TabLayout)findViewById(R.id.activity_main_tabs);
        tabs.setupWithViewPager(pager);
        tabs.setTabMode(TabLayout.MODE_FIXED);
    }
}
