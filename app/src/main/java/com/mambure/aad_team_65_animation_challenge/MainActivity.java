package com.mambure.aad_team_65_animation_challenge;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation.SplashActivity;
import com.mambure.aad_team_65_animation_challenge.animatedLayoutChange1.CuteCatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @BindView(R.id.listView_showcases) ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = null;

        // TODO Add code to launch your showcase's activity under a corresponding case block
        //  Please not the argument you put in your case cause must match the string entry
        //  you entered in the  string-array resource in strings.xml.
        switch (adapterView.getAdapter().getItem(i).toString()) {
            case "Logo animation":
                intent = new Intent(this, SplashActivity.class);
                break;
            case "Animated Layout Change 1":
                intent = new Intent(this, CuteCatActivity.class);
                break;

        }
        startActivity(intent);
    }


}
