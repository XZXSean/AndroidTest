package com.msi.studyonandroid.uiview;

import android.animation.TypeEvaluator;
import android.graphics.Point;

class FallingBallEvaluator implements TypeEvaluator<Point> {

    private Point point = new Point();

    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {

        point.x = (int) (endValue.x - fraction * (endValue.x - startValue.x));
        if (fraction * 2 <= 1){
            point.y = (int) (startValue.y + fraction * 2 * (endValue.y - startValue.y));
        } else {
            point.y = endValue.y;
        }
        return point;
    }
}
