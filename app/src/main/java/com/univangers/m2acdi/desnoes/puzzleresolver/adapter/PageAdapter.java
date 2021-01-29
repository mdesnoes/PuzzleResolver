package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;


import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.IndiceFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.IntroductionFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.PlateauFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.ResultatFragment;

import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {

    private int nbOnglets;

    private int numPuzzle;

    private List<String> tableauIndice;
    private List<String> tableauResultat;
    private String textIntro;
    private int difficulte;


    public PageAdapter(FragmentManager mgr, int numPuzzle) {
        super(mgr);
        this.nbOnglets = 4;
        this.numPuzzle = numPuzzle;

        switch (this.numPuzzle) {
            case 1:
                this.nbOnglets = 3;
                this.tableauIndice = Data.TAB_INDICE_PUZZLE1;
                this.textIntro = Data.TEXT_INTRO_PUZZLE1;
                this.difficulte = 3;
                break;
            case 2:
                this.tableauIndice = Data.TAB_INDICE_PUZZLE2;
                this.tableauResultat = Data.TAB_RESULTAT_PUZZLE2;
                this.textIntro = Data.TEXT_INTRO_PUZZLE2;
                this.difficulte = 3;
                break;
            case 3:
                this.tableauIndice = Data.TAB_INDICE_PUZZLE3;
                this.tableauResultat = Data.TAB_RESULTAT_PUZZLE3;
                this.textIntro = Data.TEXT_INTRO_PUZZLE3;
                this.difficulte = 4;
                break;
        }
    }

    @Override
    public int getCount() {
        return(this.nbOnglets);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return IntroductionFragment.newInstance(this.textIntro, this.difficulte);
            case 1:
                return PlateauFragment.newInstance(this.numPuzzle);
            case 2:
                return IndiceFragment.newInstance(this.tableauIndice);
            case 3:
                return ResultatFragment.newInstance(this.tableauResultat, this.numPuzzle);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Intro";
            case 1:
                return "Plateau";
            case 2:
                return "Indices";
            case 3:
                return "Résultat";
            default:
                return null;
        }
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        if(position == 3) {
            super.destroyItem(container, position, object);
        }
    }
}
