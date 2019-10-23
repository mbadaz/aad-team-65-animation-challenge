package com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.activities

import android.annotation.TargetApi
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.mambure.aad_team_65_animation_challenge.R
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.adapters.ElementsRecyclerViewAdapter
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.listeners.ElementClickListener
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.model.ElementModel
import kotlinx.android.synthetic.main.activity_shared_element_list.*

class SharedElementListActivity : AppCompatActivity(), ElementClickListener {

    companion object {
        const val TITLE = "title"
        const val IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_list)

        recyclerview.adapter = ElementsRecyclerViewAdapter(this)
        recyclerview.layoutManager = GridLayoutManager(this, 2)
    }

    @TargetApi(21)
    override fun onElementClick(view: ImageView, element: ElementModel) {
        //Open detail activity with shared element transition
        val activityOptions = ActivityOptionsCompat
                .makeSceneTransitionAnimation(this, view, "artwork")
        val intent = Intent(this, SharedElementDetailActivity::class.java)
        intent.putExtra(TITLE, element.title)
        intent.putExtra(IMAGE, element.image)
        startActivity(intent, activityOptions.toBundle())
    }
}