package com.mambure.aad_team_65_animation_challenge.animatedLayoutChange1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.mambure.aad_team_65_animation_challenge.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CuteCatActivity extends AppCompatActivity {

    @BindView(R.id.imgCat)
    private ImageView catImage;
    @BindView(R.id.progressBar)
    private ProgressBar progressBar;
    @BindView(R.id.root_layout)
    private ConstraintLayout containerLayout;
    private CatRepository catRepository;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cute_cat);

        ButterKnife.bind(this);
        catRepository = new CatRepository(getApplicationContext());
        catRepository.getCatImage().observe(this, this::loadImage);
    }


    private void loadImage(String url) {
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                progressBar.setVisibility(View.INVISIBLE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Transition transition = new Slide();
                    transition.setDuration(500);
                    transition.setInterpolator(new OvershootInterpolator());
                    TransitionManager.beginDelayedTransition(containerLayout, transition);
                }
                catImage.setImageBitmap(bitmap);
                catImage.setVisibility(View.VISIBLE);

            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

            }
        };

        progressBar.setVisibility(View.VISIBLE);

        Picasso.get().load(url).noPlaceholder().into(target);
//        Glide.with(this).
//                load(url).into(catImage);
    }

    @OnClick(R.id.btnGetCat)
    void getCat() {
        catRepository.getCatImage();
    }


}
