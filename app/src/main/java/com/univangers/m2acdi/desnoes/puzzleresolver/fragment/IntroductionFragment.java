package com.univangers.m2acdi.desnoes.puzzleresolver.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.univangers.m2acdi.desnoes.puzzleresolver.R;


public class IntroductionFragment extends Fragment {

    private String textIntro;
    private int difficulte;


    public static IntroductionFragment newInstance(String textIntro, int difficulte) {
        return (new IntroductionFragment(textIntro, difficulte));
    }

    public IntroductionFragment(String textIntro, int difficulte) {
        this.textIntro = textIntro;
        this.difficulte = difficulte;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_introduction, container, false);

        TextView intro = rootView.findViewById(R.id.tv_intro);
        intro.setText(this.textIntro);

        LinearLayout layoutDifficulte = rootView.findViewById(R.id.ll_etoiles_difficulte);
        for(int i=1; i<=5; ++i) {
            ImageView img = null;
            if(i <= difficulte) {
                img = new ImageView(rootView.getContext());
                img.setImageResource(R.drawable.ic_etoile_pleine);
            } else {
                img = new ImageView(rootView.getContext());
                img.setImageResource(R.drawable.ic_etoile_vide);
            }
            layoutDifficulte.addView(img);
        }

        return rootView;
    }


}
