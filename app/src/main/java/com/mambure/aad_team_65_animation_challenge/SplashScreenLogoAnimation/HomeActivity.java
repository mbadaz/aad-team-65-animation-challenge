package com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mambure.aad_team_65_animation_challenge.R;
import com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation.adapter.UserAdapter;
import com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation.adapter.models.Users;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    UserAdapter userAdapter;
    List<Users> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView = findViewById(R.id.user_list);

        users.add(new Users());
        users.add(new Users());
        users.add(new Users());

        userAdapter = new UserAdapter(this, users, new UserAdapter.UserAdapterAdapterListener() {
            @Override
            public void onUserClicked(Users users) {

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(userAdapter);
    }
}
