package com.mambure.aad_team_65_animation_challenge.animatedLayoutChange1;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.Gravity;
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
    private static final String TAG = CuteCatActivity.class.getSimpleName();
    @BindView(R.id.imgCat)
    ImageView catImage;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.root_layout)
    ConstraintLayout containerLayout;
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
        progressBar.setVisibility(View.VISIBLE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Transition transition = new Slide(Gravity.RIGHT);
            transition.setDuration(500);
            transition.setInterpolator(new OvershootInterpolator());
            TransitionManager.beginDelayedTransition(containerLayout, transition);
        }

        catImage.setVisibility( View.GONE);

        Target target = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                Log.d(TAG, "Loading Image; " + bitmap.toString());
                progressBar.setVisibility(View.INVISIBLE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Transition transition = new Slide(Gravity.LEFT);
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

        Picasso.get().load(url).noPlaceholder().resize(400, 600).centerInside().into(target);
    }

    @OnClick(R.id.btnGetCat)
    void getCat() {
        catRepository.getCatImage();
    }


}
