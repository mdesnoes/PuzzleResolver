package com.univangers.m2acdi.desnoes.puzzleresolver.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapterPuzzle1;
import com.univangers.m2acdi.desnoes.puzzleresolver.custom_view.ConfigPuzzle1;

import java.util.List;

import static com.univangers.m2acdi.desnoes.puzzleresolver.R.id.rv_liste_indice;

public class IndiceFragmentPuzzle1  extends Fragment {

    private final List<String> indices;

    public static IndiceFragmentPuzzle1 newInstance(List<String> indices) {
        return (new IndiceFragmentPuzzle1(indices));
    }

    public IndiceFragmentPuzzle1(List<String> indices) {
        this.indices = indices;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_liste_indice, container, false);

        Log.i("TAG", "#############################");
        RecyclerView rv_listeIndices = rootView.findViewById(rv_liste_indice);
        rv_listeIndices.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        IndiceAdapterPuzzle1 indiceAdapter = new IndiceAdapterPuzzle1(rootView.getContext());
        rv_listeIndices.setAdapter(indiceAdapter);

        for(String indice : this.indices) {
            indiceAdapter.ajoute(indice, ConfigPuzzle1.confirmIndice(indices.indexOf(indice)));
        }


        return rootView;
    }

}
