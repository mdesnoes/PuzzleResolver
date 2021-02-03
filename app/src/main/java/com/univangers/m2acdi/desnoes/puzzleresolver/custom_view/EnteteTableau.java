package com.univangers.m2acdi.desnoes.puzzleresolver.custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.List;


public class EnteteTableau extends View {

    private Paint paintText;
    private Paint paintCellule;
    private Paint paintLabel;

    private boolean isVertical = false;
    private List<String> valeurs;
    private String label;

    public EnteteTableau(Context context, String label, List<String> valeurs, boolean isVertical) {
        super(context);
        this.valeurs = valeurs;
        this.isVertical = isVertical;
        this.label = label;
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

        paintLabel = new Paint();
        paintLabel.setTextSize(50);
        paintLabel.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
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

        float step = width/5;

        // Case contenant le label de l'entête
        if(isVertical) {
            canvas.drawRect(0 , 0, width, step, this.paintCellule);
            canvas.drawText(this.label.toUpperCase(), width/3, step/2 + 12, this.paintLabel);
        } else {
            canvas.drawRect(0, 0, step, height, this.paintCellule);
            canvas.save();
            canvas.rotate(90, 0, 10);
            canvas.restore();

            canvas.save();
            canvas.rotate(-90, 0, height/3);
            canvas.drawText(this.label.toUpperCase(), -step - 50, height/2, this.paintLabel);
            canvas.restore();
        }

        for (int i = 0, x = 0; i < this.valeurs.size(); i++, x += step) {
            if(isVertical) {
                canvas.drawRect(x, step, x + step, height, this.paintCellule);

                canvas.save();
                canvas.rotate(90, x, 10);
                canvas.drawText(this.valeurs.get(i), x + step, 0, this.paintText);
                canvas.restore();
            } else {
                canvas.drawRect(step, x, width, x+step, this.paintCellule);
                canvas.drawText(this.valeurs.get(i), 20 + step, x+50, this.paintText);
            }
        }
    }

}
