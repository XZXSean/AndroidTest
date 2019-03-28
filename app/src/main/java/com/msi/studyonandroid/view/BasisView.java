package com.msi.studyonandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class BasisView extends View {
    public BasisView(Context context) {
        super(context);
    }

    public BasisView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasisView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Paint
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        Rect rect1 = new Rect(100,100,200,300);
        Rect rect2 = new Rect(150,150,250,200);
        Log.i("paint", "onDraw: " + Rect.intersects(rect1,rect2));
        canvas.drawRect(rect1,paint);

        paint.setColor(Color.LTGRAY);
        canvas.drawRect(rect2,paint);
        rect1.union(rect2);
        paint.setColor(Color.RED);
        canvas.drawRect(rect1,paint);
//
//        paint.setColor(0x7EFFFF00);
//        canvas.drawCircle(190,200,100,paint);
//
//        // line
//        paint.setColor(Color.LTGRAY);
//        paint.setStyle(Paint.Style.FILL_AND_STROKE);
//        paint.setStrokeWidth(50);
//        canvas.drawLine(100,100,300,300,paint);
//
//        paint.setStrokeWidth(5);
//        float[] pts = {10,10,100,200,200,250,300,300,400,400};
//        canvas.drawLines(pts,paint);
//
//        paint.setColor(Color.DKGRAY);
//        canvas.drawRect(10,20,100,100,paint);
//
//        paint.setColor(Color.LTGRAY);
//        RectF rectF = new RectF(100,10,300,100);
//        canvas.drawRoundRect(rectF,10,25,paint);
    }
}
