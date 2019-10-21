package com.mambure.aad_team_65_animation_challenge;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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
        // TODO Add code to launch your showcase's activity under a corresponding case block
        //  Please not the value you put in your invocation of case must match the string entry
        //  you entered in the  string-array resource in strings.xml.

        switch (adapterView.getSelectedItem().toString()) {


        }
    }


}
