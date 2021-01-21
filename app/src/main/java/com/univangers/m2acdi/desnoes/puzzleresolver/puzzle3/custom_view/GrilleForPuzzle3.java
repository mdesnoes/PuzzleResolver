package com.univangers.m2acdi.desnoes.puzzleresolver.puzzle3.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import com.univangers.m2acdi.desnoes.puzzleresolver.ColorCellule;

import java.util.ArrayList;
import java.util.List;


public class GrilleForPuzzle3 extends View {

    private Integer nbLignes;
    private Integer nbColonnes;

    private Paint paintText;
    private Paint paintCellule;

    private List<CelluleForPuzzle3> celluleForPuzzle3s = new ArrayList<>();

    private List<String> tabAttributsLigne;
    private List<String> tabAttributsColonne;

    private int posX;
    private int posY;

    public GrilleForPuzzle3(Context context, int nbLignes, int nbColonnes, List<String> tabAttributsLigne, List<String> tabAttributsColonne) {
        super(context);
        this.nbLignes = nbLignes;
        this.nbColonnes = nbColonnes;
        this.tabAttributsLigne = tabAttributsLigne;
        this.tabAttributsColonne = tabAttributsColonne;
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
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        int height =  metrics.heightPixels;

        int currentWidth =  (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED)  ? MeasureSpec.getSize(widthMeasureSpec) : width/2;
        int currentHeight = (MeasureSpec.getMode(widthMeasureSpec) != MeasureSpec.UNSPECIFIED) ? MeasureSpec.getSize(heightMeasureSpec): height/2;

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
                CelluleForPuzzle3 cell = null;
                /*
                 * On vérifie la si la cellule a déjà été crée auparavant
                 */
                if (!celluleForPuzzle3s.isEmpty()) {
                    cell = getCelluleByCoord(this.posX + x, this.posY + y, this.posX + x + stepLigne, this.posY + y + stepColonne);
                }

                /*
                 * Si la cellule existe, on lui assigne sa couleur
                 * Si elle n'existe pas, on la crée
                 */
                if (cell != null) {
                    if (cell.getColor() == ColorCellule.GREEN) {
                        this.paintCellule.setColor(Color.GREEN);
                        this.paintCellule.setStyle(Paint.Style.FILL);
                    } else if (cell.getColor() == ColorCellule.RED) {
                        this.paintCellule.setColor(Color.RED);
                        this.paintCellule.setStyle(Paint.Style.FILL);
                    } else {
                        this.paintCellule.setColor(Color.BLACK);
                        paintCellule.setStyle(Paint.Style.STROKE);
                    }
                } else {
                    String valLigne = tabAttributsLigne.get(i);
                    String valColonne = tabAttributsColonne.get(j);

                    this.celluleForPuzzle3s.add(new CelluleForPuzzle3(this.posX + x, this.posY + y, this.posX + x + stepLigne, this.posY + y + stepColonne, valLigne, valColonne));
                }

                canvas.drawRect(x, y, x + stepLigne, y + stepColonne, this.paintCellule);
            }
        }
    }

    private CelluleForPuzzle3 getCelluleByCoord(int left, int top, float right, float bottom) {
        for(CelluleForPuzzle3 cell : this.celluleForPuzzle3s) {
            if(left == cell.getLeft() && top == cell.getTop() && right == cell.getRight() && bottom == cell.getBottom()) {
                return cell;
            }
        }
        return null;
    }


    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public List<CelluleForPuzzle3> getCelluleForPuzzle3s() {
        return celluleForPuzzle3s;
    }
}
