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
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapter;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapterPuzzle1;
import com.univangers.m2acdi.desnoes.puzzleresolver.custom_view.ConfigPuzzle1;

import java.util.List;

import static com.univangers.m2acdi.desnoes.puzzleresolver.R.id.rv_liste_indice;

public class IndiceFragmentPuzzle1  extends Fragment {

    private IndiceAdapterPuzzle1 indiceAdapter;
    private RecyclerView rv_listeIndices;

    private List<String> indices;

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
        this.rv_listeIndices = (RecyclerView) rootView.findViewById(rv_liste_indice);
        this.rv_listeIndices.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        this.indiceAdapter = new IndiceAdapterPuzzle1(rootView.getContext());
        this.rv_listeIndices.setAdapter(this.indiceAdapter);

        for(String indice : this.indices) {
            this.indiceAdapter.ajoute(indice, ConfigPuzzle1.confirmIndice(indices.indexOf(indice)));
        }


        return rootView;
    }

}
