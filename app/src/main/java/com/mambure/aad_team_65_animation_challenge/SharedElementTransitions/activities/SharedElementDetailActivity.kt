package com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mambure.aad_team_65_animation_challenge.R
import kotlinx.android.synthetic.main.activity_shared_element_detail.*

class SharedElementDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_element_detail)

        val title = intent.getStringExtra(SharedElementListActivity.TITLE)
        val imageId = intent.getIntExtra(SharedElementListActivity.IMAGE, 0)

        Glide.with(this)
                .load(imageId)
                .fitCenter()
                .apply(RequestOptions.circleCropTransform())
                .into(image)

        textView.text = title
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                supportFinishAfterTransition()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //TODO add more complex use case.
}