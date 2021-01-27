package com.univangers.m2acdi.desnoes.puzzleresolver.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;
import com.univangers.m2acdi.desnoes.puzzleresolver.adapter.IndiceAdapter;

import java.util.List;

public class IndiceFragment extends Fragment {

    private IndiceAdapter indiceAdapter;
    private RecyclerView rv_listeIndices;

    private List<String> indices;
    private String textIntro;

    public static IndiceFragment newInstance(List<String> indices, String textIntro) {
        return (new IndiceFragment(indices, textIntro));
    }

    public IndiceFragment(List<String> indices, String textIntro) {
        this.indices = indices;
        this.textIntro =textIntro;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        TextView intro = rootView.findViewById(R.id.tv_intro);
        intro.setText(this.textIntro);

        return rootView;
    }

}
