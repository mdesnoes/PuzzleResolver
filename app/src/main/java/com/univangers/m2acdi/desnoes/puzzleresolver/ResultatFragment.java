package com.univangers.m2acdi.desnoes.puzzleresolver;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

import java.util.List;

import static com.univangers.m2acdi.desnoes.puzzleresolver.Data.TAB_FILM;
import static com.univangers.m2acdi.desnoes.puzzleresolver.Data.TAB_JOUR;
import static com.univangers.m2acdi.desnoes.puzzleresolver.Data.TAB_NOM;
import static com.univangers.m2acdi.desnoes.puzzleresolver.Data.TAB_TEMPS;

public class ResultatFragment extends Fragment {

    private List<String> resultats;

    public static ResultatFragment newInstance(List<String> resultats) {
        return (new ResultatFragment(resultats));
    }

    public ResultatFragment(List<String> resultats) {
        this.resultats = resultats;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resultat, container, false);

        TableLayout tl = rootView.findViewById(R.id.tl_resultat);
        tl.setStretchAllColumns(true);

        ajoutEnTete(tl);

        List<String> valeurColonne1 = Data.getTableauValeursByNomAttribut(this.resultats.get(0));
        for(String val : valeurColonne1) {
            ajoutLigne(tl, val);
        }

        return rootView;
    }

    private void ajoutLigne(TableLayout tl, String val) {
        TableRow ligne = new TableRow(tl.getContext());
        ligne.setPadding(8,8,8,8);
        ligne.setBackgroundResource(R.drawable.row_border);

        TextView tv_col1 = new TextView(ligne.getContext());
        tv_col1.setGravity(Gravity.CENTER);
        tv_col1.setText(val);
        tv_col1.setTextSize(25);
        tv_col1.setBackgroundResource(R.drawable.row_border);

        ligne.addView(tv_col1);

        for(int i=1; i<this.resultats.size(); ++i) {
            TextView tv = new TextView(ligne.getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText("");
            tv.setTextSize(25);
            tv.setBackgroundResource(R.drawable.row_border);


            ligne.addView(tv);
        }

        tl.addView(ligne);
    }

    private void ajoutEnTete(TableLayout tl) {
        TableRow entete = new TableRow(tl.getContext());
        entete.setPadding(8,8,8,8);
        entete.setBackgroundResource(R.drawable.row_border);

        for(String str : this.resultats) {
            TextView tv = new TextView(entete.getContext());
            tv.setGravity(Gravity.CENTER);
            tv.setText(str);
            tv.setTextSize(25);
            tv.setTypeface(Typeface.DEFAULT_BOLD);
            tv.setBackgroundResource(R.drawable.row_border);


            entete.addView(tv);
        }
        tl.addView(entete);
    }

}
