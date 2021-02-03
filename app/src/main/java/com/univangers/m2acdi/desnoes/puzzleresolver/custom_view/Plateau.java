package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.univangers.m2acdi.desnoes.puzzleresolver.DataResultat;
import com.univangers.m2acdi.desnoes.puzzleresolver.EtatCellule;
import com.univangers.m2acdi.desnoes.puzzleresolver.Data;
import com.univangers.m2acdi.desnoes.puzzleresolver.R;

import java.util.ArrayList;
import java.util.List;


public class Plateau extends ViewGroup {

    private List<EnteteTableau> entetes;
    private List<Grille> grilles;

    private float touchEventX;
    private float touchEventY;

    public Plateau(Context context) {
        super(context);
    }



    public Plateau(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray attr_array = context.obtainStyledAttributes(attrs, R.styleable.Plateau);
        String att1 = attr_array.getString(R.styleable.Plateau_attribut1);
        String att2 = attr_array.getString(R.styleable.Plateau_attribut2);
        String att3 = attr_array.getString(R.styleable.Plateau_attribut3);
        String att4 = attr_array.getString(R.styleable.Plateau_attribut4);


        /**
         * On recupère un tableau des données en fonction des noms des attributs
         */
        List<String> tabValeurAtt1 = Data.getTableauValeursByNomAttribut(att1);
        List<String> tabValeurAtt2 = Data.getTableauValeursByNomAttribut(att2);
        List<String> tabValeurAtt3 = Data.getTableauValeursByNomAttribut(att3);
        List<String> tabValeurAtt4 = Data.getTableauValeursByNomAttribut(att4);

        DataResultat.initResultatVide(tabValeurAtt4);

        this.entetes = new ArrayList<EnteteTableau>();
        this.entetes.add(new EnteteTableau(getContext(), att1, tabValeurAtt1, true));
        this.entetes.add(new EnteteTableau(getContext(), att2, tabValeurAtt2, true));
        this.entetes.add(new EnteteTableau(getContext(), att3, tabValeurAtt3, true));
        this.entetes.add(new EnteteTableau(getContext(), att4, tabValeurAtt4, false));
        this.entetes.add(new EnteteTableau(getContext(), att3, tabValeurAtt3, false));
        this.entetes.add(new EnteteTableau(getContext(), att2, tabValeurAtt2, false));



        this.grilles = new ArrayList<Grille>();
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt4, tabValeurAtt1, att1));
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt4, tabValeurAtt2, att2));
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt4, tabValeurAtt3, att3));
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt3, tabValeurAtt1, ""));
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt3, tabValeurAtt2, ""));
        this.grilles.add(new Grille(getContext(), 5, 5, tabValeurAtt2, tabValeurAtt1, ""));


        /*
         * Les addView()
         */
        this.entetes.forEach(enteteTableau -> addView(enteteTableau));
        this.grilles.forEach(grille -> addView(grille));
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = this.getChildCount();
        for (int i = 0 ; i < count ; i++){
            final View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }


    @Override
    protected void onLayout(boolean bool, int l, int t, int r, int b) {
        float taille = getWidth();
        int step = (int)taille/4;

        // Première ligne du plateau : L'entête avec les attributs 1 , 2 et 3 (vertical)
        for (int i= 0, x = step; i < 3; i++, x+=step ) {
            this.entetes.get(i).layout(x, 0, x+step, step);
        }

        int currentHeight = step;

        // Deuxième ligne du plateau : L'entête avec l'attribut 4 (horizontal) suvis de 3 grilles
        this.entetes.get(3).layout(0, currentHeight, step, currentHeight+step);
        for (int i= 0, s = step; i < 3; i++, s += step ) {
            this.grilles.get(i).setPosX(s);
            this.grilles.get(i).setPosY(currentHeight);
            this.grilles.get(i).layout(s, currentHeight,s + step, currentHeight + step);

            // Recherche si la cellule sur laquelle on a cliqué est ici
            for(Cellule cell : this.grilles.get(i).getCellules()) {
                if(coordonneeAppartientCellule(this.touchEventX, this.touchEventY, cell)) {
                    actionCelluleCourante(this.grilles.get(i), cell);
                }
            }
        }

        currentHeight += step;

        // Troisième ligne du plateau : L'entète avec l'attribut 3 (horizontal) suvis de 2 grilles
        this.entetes.get(4).layout(0, currentHeight, step, currentHeight + step);
        for (int i= 3, s = step; i < 5; i++, s += step ) {
            this.grilles.get(i).setPosX(s);
            this.grilles.get(i).setPosY(currentHeight);
            this.grilles.get(i).layout(s, currentHeight,s + step, currentHeight + step);

            // Recherche si la cellule sur laquelle on a cliqué est ici
            for(Cellule cell : this.grilles.get(i).getCellules()) {
                if(coordonneeAppartientCellule(this.touchEventX, this.touchEventY, cell)) {
                    actionCelluleCourante(this.grilles.get(i), cell);
                }
            }
        }

        currentHeight += step;

        // Dernière ligne du plateau : L'entète avec l'attribut 2 (horizontal) suvis de 1 grille
        this.entetes.get(5).layout(0, currentHeight, step, currentHeight + step);

        this.grilles.get(5).setPosX(step);
        this.grilles.get(5).setPosY(currentHeight);
        this.grilles.get(5).layout(step, currentHeight,step*2, currentHeight + step);
        // Recherche si la cellule sur laquelle on a cliqué est ici
        for(Cellule cell : this.grilles.get(5).getCellules()) {
            if(coordonneeAppartientCellule(this.touchEventX, this.touchEventY, cell)) {
                actionCelluleCourante(this.grilles.get(5), cell);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchEventX = event.getX();
        touchEventY = event.getY();
        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        requestLayout();
        return true;
    }

    /**
     * Permet de changer l'etat de la cellule courante (sur laquelle on a cliqué) et de faire les action nécéssaires.
     * @param grille
     * @param cell
     */
    private void actionCelluleCourante(Grille grille, Cellule cell) {
        // Si l"etat est VIDE, le nouvel etat est INVALIDE
        if(cell.getEtat() == EtatCellule.VIDE) {
            cell.setEtat(EtatCellule.INVALIDE);
        } else if(cell.getEtat() == EtatCellule.INVALIDE) { // Si l"etat est INVALIDE, le nouvel etat est VALIDE si c'est possible

            // On verifie que la cellule n'est pas sur une ligne ou une colonne avec une cellule déjà validée
            if (!grille.presenceCelluleValideeOnColonne(cell.getValColonne()) && !grille.presenceCelluleValideeOnLigne(cell.getValLigne())) {
                cell.setEtat(EtatCellule.VALIDE);
                grille.changeEtatOthersCellules(cell, EtatCellule.INVALIDE); // Maj des cellules qui sont sur la même ligne ou la même colonne
                grille.addCelluleValidee(cell);
            }

        } else if(cell.getEtat() == EtatCellule.VALIDE) { // Si l'etat est VALIDE, le nouvel etat est VIDE
            cell.setEtat(EtatCellule.VIDE);
            grille.removeCelluleInvalidee(cell);
            grille.changeEtatOthersCellules(cell, EtatCellule.VIDE);  // Maj des cellules qui sont sur la même ligne et colonne
        }
        grille.invalidate();
    }


    public boolean coordonneeAppartientCellule(float x, float y, Cellule cell) {
        //Log.i("TAG", "Left : " + cell.getLeft() + " - Right : " + cell.getRight() + " - Top : " + cell.getTop() + " - Bottom : " + cell.getBottom());
        return (x >= cell.getLeft() && x < cell.getRight()) && (y >= cell.getTop() && y < cell.getBottom());
    }

}
