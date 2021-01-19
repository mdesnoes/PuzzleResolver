package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapter;

import java.util.List;

public class IndiceFragment extends Fragment {

    private IndiceAdapter indiceAdapter;
    private RecyclerView rv_listeIndices;

    public List<String> indices;

    public static IndiceFragment newInstance(List<String> indices) {
        return (new IndiceFragment(indices));
    }

    public IndiceFragment(List<String> indices) {
        this.indices = indices;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        this.rv_listeIndices = (RecyclerView) getActivity().findViewById(R.id.rv_liste_indice);
//        this.rv_listeIndices.setLayoutManager(new LinearLayoutManager(getContext()));
//        this.indiceAdapter = new IndiceAdapter(getContext());
//        this.rv_listeIndices.setAdapter(this.indiceAdapter);
//
//        for(String indice : this.indices) {
//            this.indiceAdapter.ajoute(indice);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_liste_indice, container, false);

        this.rv_listeIndices = (RecyclerView) rootView.findViewById(R.id.rv_liste_indice);
        this.rv_listeIndices.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        this.indiceAdapter = new IndiceAdapter(rootView.getContext());
        this.rv_listeIndices.setAdapter(this.indiceAdapter);

        for(String indice : this.indices) {
            this.indiceAdapter.ajoute(indice);
        }

        return rootView;
    }

}
