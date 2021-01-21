package com.univangers.m2acdi.desnoes.puzzleresolver.puzzle3.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.List;


public class EnteteTableauForPuzzle3 extends View {

    private Paint paintText;
    private Paint paintCellule;

    private boolean isVertical = false;
    private List<String> valeurs;

    public EnteteTableauForPuzzle3(Context context, List<String> valeurs, boolean isVertical) {
        super(context);
        this.valeurs = valeurs;
        this.isVertical = isVertical;
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
        paintText.setColor(Color.BLUE);
        paintText.setTextSize(50);
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

        float step = width/5;

        for (int i = 0, x = 0; i < this.valeurs.size(); i++, x += step) {
            if(isVertical) {
                canvas.drawRect(x, 0, x + step, height, this.paintCellule);

                canvas.save();
                canvas.rotate(90, x, 10);
                canvas.drawText(this.valeurs.get(i), x, 0, this.paintText);
                canvas.restore();
            } else {
                canvas.drawRect(0, x, width, x+step, this.paintCellule);
                canvas.drawText(this.valeurs.get(i), 20, x+50, this.paintText);
            }
        }
    }

}
