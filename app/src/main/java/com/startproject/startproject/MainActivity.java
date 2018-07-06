package com.startproject.startproject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.view.View;
import android.widget.TextView;

import static android.view.View.GONE;

public class MainActivity extends Activity {

    private TextView mInView;
    private TextView mOutView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mInView = findViewById(R.id.view1);
        mOutView = findViewById(R.id.view2);

        crossfade(mInView, mOutView);

    }

    public void crossfade(final View inView, View outView) {
        inView.setAlpha(0f);
        inView.setVisibility(View.VISIBLE);
        inView.animate()
                .alpha(1f)
                .setDuration(5000)
                .setInterpolator(new FastOutLinearInInterpolator());

        outView.animate()
                .alpha(0f)
                .setDuration(5000)
                .setInterpolator(new FastOutLinearInInterpolator())
                .withEndAction(() -> outView.setVisibility(GONE));
    }
}