package com.startproject.startproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView view1;
    private TextView view2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);

        crossfide(view1, view2);

    }

    public void crossfide(final View view1, View view2) {

        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0f, 1f);
        ValueAnimator valueAnimator2 = ValueAnimator.ofFloat(1f, 0f);

        valueAnimator1.setInterpolator(new LinearOutSlowInInterpolator());
        valueAnimator2.setInterpolator(new FastOutLinearInInterpolator());

        valueAnimator1.addUpdateListener(animator -> view1.setAlpha((Float) animator.getAnimatedValue()));
        valueAnimator2.addUpdateListener(animator -> view2.setAlpha((Float) animator.getAnimatedValue()));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(valueAnimator1, valueAnimator2);
        set.setDuration(20000);

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view2.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                view1.setVisibility(View.VISIBLE);
            }
        });

        set.start();
    }
}