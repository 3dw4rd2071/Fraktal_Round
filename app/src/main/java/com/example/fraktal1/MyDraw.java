package com.example.fraktal1;

import android.view.View;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;


public class MyDraw extends View {
    Paint paint = new Paint();
    int wei,hei;
    @Override
    protected void onSizeChanged(int wei, int hei, int oldwei, int oldhei) {
        this.wei = wei;
        this.hei = hei;
    }

    public MyDraw(Context context) {
        super(context);

        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);

    }

    @Override
    protected void onDraw(Canvas canvas){
        drawCircles(canvas, wei/2, hei/2, 300);
    }

    public void drawCircles(Canvas canvas, int x, int y, int r){
        canvas.drawCircle(x, y, r, paint);
        if(r > 80) {
            drawCircles(canvas, x, y - r, r / 2);
            drawCircles(canvas, x + r, y, r / 2);
            drawCircles(canvas, x, y + r, r / 2);
            drawCircles(canvas, x - r, y, r / 2);
        }
    }



}