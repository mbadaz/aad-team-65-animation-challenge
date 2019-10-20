package com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mambure.aad_team_65_animation_challenge.R;
import com.mambure.aad_team_65_animation_challenge.SplashScreenLogoAnimation.adapter.models.Users;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context context;
    private List<Users> usersList;
    private UserAdapterAdapterListener listener;
    long DURATION = 500;
    private boolean on_attach = true;

    public UserAdapter(Context context, List<Users> usersList, UserAdapterAdapterListener listener) {
        this.context = context;
        this.usersList = usersList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_user, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.MyViewHolder holder, int position) {
        Users users = usersList.get(position);
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUserClicked(users);
            }
        });
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
View view;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            view= itemView;
        }
    }

    public  interface UserAdapterAdapterListener {

        void onUserClicked(Users users );
    }

    private void setAnimation(View itemView, int i) {
        /*if(!on_attach){
            i = -1;
        }
        boolean isNotFirstItem = i == -1;
        i++;
        itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animator = ObjectAnimator.ofFloat(itemView, "alpha", 0.f, 0.5f, 1.0f);
        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
        animator.setStartDelay(isNotFirstItem ? DURATION / 2 : (i * DURATION / 3));
        animator.setDuration(500);
        animatorSet.play(animator);
        animator.start();*/
        if(!on_attach){
            i = -1;
        }
        boolean not_first_item = i == -1;
        i = i + 1;
        itemView.setTranslationX(-400f);
        itemView.setAlpha(0.f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(itemView, "translationX", -400f, 0);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(itemView, "alpha", 1.f);
        ObjectAnimator.ofFloat(itemView, "alpha", 0.f).start();
        animatorTranslateY.setStartDelay(not_first_item ? DURATION : (i * DURATION));
        animatorTranslateY.setDuration((not_first_item ? 2 : 1) * DURATION);
        animatorSet.playTogether(animatorTranslateY, animatorAlpha);
        animatorSet.start();


    }
}
