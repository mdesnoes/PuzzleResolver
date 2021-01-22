package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.IndiceFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.PlateauFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.fragment.ResultatFragment;

import java.util.List;

public class PageAdapter extends FragmentPagerAdapter {

    private int nbOnglets;

    private int numPuzzle;

    private List<String> tableauIndice;
    private List<String> tableauResultat;

    public PageAdapter(FragmentManager mgr, int numPuzzle) {
        super(mgr);
        this.nbOnglets = 3;
        this.numPuzzle = numPuzzle;

        switch (this.numPuzzle) {
            case 1:
                this.tableauIndice = null;
                this.tableauResultat = null;
                break;
            case 2:
                this.tableauIndice = Data.TAB_INDICE_PUZZLE2;
                this.tableauResultat = Data.TAB_RESULTAT_PUZZLE2;
                break;
            case 3:
                this.tableauIndice = Data.TAB_INDICE_PUZZLE3;
                this.tableauResultat = Data.TAB_RESULTAT_PUZZLE3;
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
                return PlateauFragment.newInstance(this.numPuzzle);
            case 1:
                return IndiceFragment.newInstance(this.tableauIndice);
            case 2:
                return ResultatFragment.newInstance(this.tableauResultat);
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Plateau";
            case 1:
                return "Indices";
            case 2:
                return "Résultat";
            default:
                return null;
        }
    }
}
