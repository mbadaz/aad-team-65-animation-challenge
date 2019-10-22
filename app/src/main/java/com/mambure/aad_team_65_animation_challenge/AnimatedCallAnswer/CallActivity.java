package com.mambure.aad_team_65_animation_challenge.AnimatedCallAnswer;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mambure.aad_team_65_animation_challenge.R;

public class CallActivity extends AppCompatActivity {

    private ImageView mImgCallIcon;
    private int currentBackgroundColor;
    private ValueAnimator mBackgroundAnimation;
    private int num = 1;
    private View mRootLayout;
    private ObjectAnimator mTranslationAnimation;
    private ObjectAnimator mRotationAnimation;
    private int mDirection = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        mImgCallIcon = (ImageView) findViewById(R.id.img_call_icon);
        currentBackgroundColor = Color.WHITE;

        mRootLayout = findViewById(R.id.root_layout);

        mRootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (num == 1) {
                    playAnswer();
                    num = 2;
                    return;
                } else if (num == 2) {
                    revert();
                    num = 3;
                    return;
                } else if (num == 3) {
                    playReject();
                    num = 4;
                    return;
                } else {
                    revert();
                    num = 1;
                    return;
                }
            }
        });

    }

    private void revert() {
        mTranslationAnimation.reverse();
        mBackgroundAnimation.reverse();
    }

    private void playReject() {
        initializeBackgroundColorAnimation(1);
        initializeTranslationAnimation(mRootLayout.getWidth() - 10 - mImgCallIcon.getWidth());

        mBackgroundAnimation.start();
        mTranslationAnimation.start();
    }

    private void playAnswer() {
        initializeBackgroundColorAnimation(0);
        initializeTranslationAnimation(0 + 10);

        mBackgroundAnimation.start();
        mTranslationAnimation.start();
    }

    private void initializeTranslationAnimation(int endingValue) {
        mTranslationAnimation = ObjectAnimator.ofFloat(mImgCallIcon, "x", endingValue);
        mTranslationAnimation.setDuration(750);
    }


    private void initializeBackgroundColorAnimation(int action) {
        int colorFrom = Color.WHITE;
        int colorTo = 0;

        switch (action) {
            case 0:
                colorTo = getResources().getColor(R.color.call_answer);
                break;
            case 1:
                colorTo = getResources().getColor(R.color.call_reject);
                break;
        }

        mBackgroundAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        mBackgroundAnimation.setDuration(750);
        mBackgroundAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                mRootLayout.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
    }

}
