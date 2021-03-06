package com.univangers.m2acdi.desnoes.puzzleresolver.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.DataResultat;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.Indice;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapter;
import com.univangers.m2acdi.desnoes.puzzleresolver.custom_view.ConfigPuzzle1;

import java.util.List;

import static com.univangers.m2acdi.desnoes.puzzleresolver.R.id.rv_liste_indice;

public class IndiceFragment extends Fragment {

    private IndiceAdapter indiceAdapter;
    private RecyclerView rv_listeIndices;

    private List<String> indices;

    public static IndiceFragment newInstance(List<String> indices) {
        return (new IndiceFragment(indices));
    }

    public IndiceFragment(List<String> indices) {
        this.indices = indices;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_liste_indice, container, false);

        this.rv_listeIndices = (RecyclerView) rootView.findViewById(rv_liste_indice);
        this.rv_listeIndices.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        this.indiceAdapter = new IndiceAdapter(rootView.getContext());
        this.rv_listeIndices.setAdapter(this.indiceAdapter);

        for(String indice : this.indices) {
            this.indiceAdapter.ajoute(indice, false);
        }

        return rootView;
    }




}
