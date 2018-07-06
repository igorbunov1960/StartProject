package com.startproject.startproject;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mInView;
    private TextView mOutView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mInView = findViewById(R.id.view1);
        mOutView = findViewById(R.id.view2);

        crossfide(mInView, mOutView);

    }

    public void crossfide(final View inView, View outView) {
        AnimatorSet set = new AnimatorSet();

        set.playTogether(ObjectAnimator.ofFloat(outView, View.ALPHA, 1f, 0f),
                ObjectAnimator.ofFloat(inView, View.ALPHA, 0f, 1f));

        set.setDuration(10000);

        set.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mOutView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mInView.setVisibility(View.VISIBLE);
            }
        });


        set.start();
    }





}