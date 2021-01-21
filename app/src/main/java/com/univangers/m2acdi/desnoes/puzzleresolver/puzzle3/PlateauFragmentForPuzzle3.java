package com.univangers.m2acdi.desnoes.puzzleresolver.puzzle3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.univangers.m2acdi.desnoes.puzzleresolver.PlateauFragment;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

public class PlateauFragmentForPuzzle3 extends Fragment {

    public static PlateauFragmentForPuzzle3 newInstance() {
        return (new PlateauFragmentForPuzzle3());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_plateau_puzzle3, container, false);
    }
}
