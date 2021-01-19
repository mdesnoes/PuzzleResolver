package com.univangers.m2acdi.desnoes.puzzleresolver.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.IndiceFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.PlateauFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.ResultatFragment;

public class PageAdapter extends FragmentPagerAdapter {


    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(3);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return PlateauFragment.newInstance();
            case 1:
                return IndiceFragment.newInstance(Data.TAB_INDICE_PUZZLE2);
            case 2:
                return ResultatFragment.newInstance();
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
