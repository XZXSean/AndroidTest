package com.msi.studyonandroid.uiview;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.msi.studyonandroid.R;

public class UIViewActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uiview);

        imageView = findViewById(R.id.ball_img);

        findViewById(R.id.anim_begin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Animation animation = AnimationUtils.loadAnimation(UIViewActivity.this, R.anim.scaleanim);
//                textView.startAnimation(animation);
//                doAnimation();

                ValueAnimator valueAnimator = ValueAnimator.ofObject(new FallingBallEvaluator(), new Point(0,0),
                        new Point(700,700));
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        Point mCurPoint = (Point) animation.getAnimatedValue();
                        imageView.layout(mCurPoint.x,mCurPoint.y,mCurPoint.x+imageView.getWidth(),mCurPoint.y+imageView.getHeight());
                    }
                });
                valueAnimator.setDuration(2000);

                ValueAnimator valueAnimator1 = ValueAnimator.ofInt(0, 400);
                valueAnimator1.setDuration(1000);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) animation.getAnimatedValue();
                        textView.layout(curValue, curValue, curValue + textView.getWidth(), curValue + textView.getHeight());
                    }
                });

                AnimatorSet set = new AnimatorSet();
//                set.playSequentially(valueAnimator,valueAnimator1);
                set.playTogether(valueAnimator,valueAnimator1);
                set.start();



            }
        });
        textView = findViewById(R.id.anim_show_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UIViewActivity.this, "click me", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doAnimation() {
        ValueAnimator valueAnimator1 = ValueAnimator.ofInt(0, 400);
        valueAnimator1.setDuration(1000);

        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();
                textView.layout(curValue, curValue, curValue + textView.getWidth(), curValue + textView.getHeight());
            }
        });
        valueAnimator1.start();
    }
}
