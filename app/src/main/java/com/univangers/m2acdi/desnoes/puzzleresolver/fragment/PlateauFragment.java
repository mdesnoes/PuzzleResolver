package com.univangers.m2acdi.desnoes.puzzleresolver.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;
import com.univangers.m2acdi.desnoes.puzzleresolver.custom_view.Plateau;

public class PlateauFragment extends Fragment {

    private int numPuzzle;

    public static PlateauFragment newInstance(int numPuzzle) {
        return (new PlateauFragment(numPuzzle));
    }

    public PlateauFragment(int numPuzzle) {
        this.numPuzzle = numPuzzle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        switch(this.numPuzzle) {
            case 2: return inflater.inflate(R.layout.fragment_plateau_puzzle2, container, false);
            case 3: return inflater.inflate(R.layout.fragment_plateau_puzzle3, container, false);
            default: return null;
        }
    }

}
