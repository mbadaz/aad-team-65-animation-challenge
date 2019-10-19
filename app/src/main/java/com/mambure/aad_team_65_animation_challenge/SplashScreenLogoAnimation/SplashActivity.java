package com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import com.mambure.aad_team_65_animation_challenge.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    LinearLayout startBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_spash);
        startBtn = findViewById(R.id.container);
        TextView title = findViewById(R.id.app_name);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/font_name.ttf");
        title.setTypeface(custom_font);
        startBtn.setVisibility(View.GONE);
        Animation animTranslate  = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.translate);
        animTranslate.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) { }
            @Override
            public void onAnimationRepeat(Animation arg0) { }

            @Override
            public void onAnimationEnd(Animation arg0) {

                startBtn.setVisibility(View.VISIBLE);
                Animation animFade  = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.fade);
                startBtn.startAnimation(animFade);
            }
        });

        findViewById(R.id.container).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                finish();
            }
        });
        ImageView imgLogo =findViewById(R.id.logo);
        imgLogo.startAnimation(animTranslate);



    }

}
