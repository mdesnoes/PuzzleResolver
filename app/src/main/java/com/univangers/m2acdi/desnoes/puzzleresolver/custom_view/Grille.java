package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import com.univangers.m2acdi.desnoes.puzzleresolver.DataResultat;
import com.univangers.m2acdi.desnoes.puzzleresolver.EtatCellule;

import java.util.ArrayList;
import java.util.List;


public class Grille extends View {

    private final static String TEXT_CELL_VALIDE = "O";
    private final static String TEXT_CELL_INVALIDE = "X";


    private Integer nbLignes;
    private Integer nbColonnes;

    private Paint paintText;
    private Paint paintCellule;

    private List<Cellule> cellules = new ArrayList<>();
    private List<Cellule> cellulesValidees = new ArrayList<>();

    private List<String> tabAttributsLigne;
    private List<String> tabAttributsColonne;
    private String nomValColonne;

    private int posX;
    private int posY;

    public Grille(Context context, int nbLignes, int nbColonnes, List<String> tabAttributsLigne, List<String> tabAttributsColonne, String nomValColonne) {
        super(context);
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.tabAttributsLigne = tabAttributsLigne;
        this.tabAttributsColonne = tabAttributsColonne;
        this.nomValColonne = nomValColonne; // Permet de mettre à jour le tableau des résultats, s'il est vide, c'est que cette grille n'est pas utilisé pour calculer les resultats
        setUpPaint(); // style rectangle avec bordure
    }

    private void setUpPaint() {
        paintCellule = new Paint();
        paintCellule.setColor(Color.BLACK);
        paintCellule.setAntiAlias(true);
        paintCellule.setStrokeWidth(5);
        paintCellule.setStyle(Paint.Style.STROKE);
        paintCellule.setStrokeJoin(Paint.Join.ROUND);
        paintCellule.setStrokeCap(Paint.Cap.ROUND);

        paintText = new Paint();
        paintText.setColor(Color.BLACK);
        paintText.setTextSize(80);
        paintText.setFakeBoldText(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height =  metrics.heightPixels;

        int currentWidth =  (View.MeasureSpec.getMode(widthMeasureSpec) != View.MeasureSpec.UNSPECIFIED)  ? View.MeasureSpec.getSize(widthMeasureSpec) : width/2;
        int currentHeight = (View.MeasureSpec.getMode(widthMeasureSpec) != View.MeasureSpec.UNSPECIFIED) ? View.MeasureSpec.getSize(heightMeasureSpec): height/2;

        setMeasuredDimension(currentWidth,currentHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();

        float stepLigne = nbLignes > 0 ? width / nbLignes : width;
        float stepColonne = nbColonnes > 0 ? height / nbColonnes : height;

        for (int i = 0, x = 0; i < nbLignes; i++, x += stepLigne) {
            for (int j = 0, y = 0; j < nbColonnes; j++, y += stepColonne) {
                Cellule cell = null;
                if (!cellules.isEmpty()) {
                    cell = getCelluleByCoord(this.posX + x, this.posY + y, this.posX + x + stepLigne, this.posY + y + stepColonne);
                }

                /*
                 * Si la cellule existe, on lui assigne son texte
                 * Si elle n'existe pas, on la crée
                 */
                if (cell != null) {
                    //Log.i("TAG", cell.getValLigne() + " - " + cell.getValColonne());

                    if (cell.getEtat() == EtatCellule.VALIDE) {

                        this.paintText.setColor(Color.GREEN);
                        canvas.drawText(TEXT_CELL_VALIDE, x + 10, y + stepColonne - 5, this.paintText);

                        // Mise à jour du tableau de resultat
                        if(!this.nomValColonne.isEmpty()) {
                            DataResultat.updateResultat(cell.getValLigne(), this.nomValColonne, cell.getValColonne());
                        }
                    } else if (cell.getEtat() == EtatCellule.INVALIDE) {
                        this.paintText.setColor(Color.RED);
                        canvas.drawText(TEXT_CELL_INVALIDE, x + 10, y + stepColonne - 5, this.paintText);
                    }
                } else {
                    String valLigne = tabAttributsLigne.get(j);
                    String valColonne = tabAttributsColonne.get(i);

                    this.cellules.add(new Cellule(this.posX + x, this.posY + y, this.posX + x + stepLigne, this.posY + y + stepColonne, valLigne, valColonne));
                }

                canvas.drawRect(x, y, x + stepLigne, y + stepColonne, this.paintCellule);
            }
        }
    }

    private Cellule getCelluleByCoord(int left, int top, float right, float bottom) {
        for(Cellule cell : this.cellules) {
            if(left == cell.getLeft() && top == cell.getTop() && right == cell.getRight() && bottom == cell.getBottom()) {
                return cell;
            }
        }
        return null;
    }

    /**
     * Retourne vrai si la cellule en paramètre est sur la ligne ou la colonne d'une cellule validée
     * @param cell
     * @return
     */
    public boolean verificationCelluleDejaValidee(Cellule cell) {
        for(Cellule cellVal : this.cellulesValidees) {
            if(cellVal.getValLigne().equals(cell.getValLigne()) || cellVal.getValColonne().equals(cell.getValColonne())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Permet de mettre à jour les couleurs des cellules sur la ligne et la colonne de la celulle courante
     * @param currentCell
     * @param nextEtat
     */
    public void changeEtatOthersCellules(Cellule currentCell, EtatCellule nextEtat) {
        String valColonneCurrentCell = currentCell.getValColonne();
        String valLigneCurrentCell = currentCell.getValLigne();

        for(Cellule cell : this.cellules) {
            // On cherche les cellules qui sont sur la même ligne ou la même colonne
            if(cell.getValColonne().equals(valColonneCurrentCell) || cell.getValLigne().equals(valLigneCurrentCell)) {
                // On verifie qu ce n'est pas la même cellule que la celulle courante
                if(!(cell.getValColonne().equals(valColonneCurrentCell) && cell.getValLigne().equals(valLigneCurrentCell))) {

                    if(this.cellulesValidees.isEmpty()) {
                        cell.setEtat(nextEtat);
                    } else {
                        // On change l'etat de la cellule si elle n'entre pas en conflit avec les lignes/colonnes des autres celulles validées
                        for (Cellule cellValidee : this.cellulesValidees) {
                            if (!cellValidee.getValLigne().equals(cell.getValLigne()) && !cellValidee.getValColonne().equals(cell.getValColonne())) {
                                cell.setEtat(nextEtat);
                            }
                        }
                    }

                }
            }
        }
    }


    public void addCelluleValidee(Cellule cell) {
        this.cellulesValidees.add(cell);
    }

    public void removeCelluleInvalidee(Cellule cell) {
        this.cellulesValidees.remove(cell);
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public List<Cellule> getCellules() {
        return cellules;
    }

}
