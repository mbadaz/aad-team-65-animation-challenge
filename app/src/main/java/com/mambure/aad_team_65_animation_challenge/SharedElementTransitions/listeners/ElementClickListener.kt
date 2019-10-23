package com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.listeners

import android.widget.ImageView
import com.mambure.aad_team_65_animation_challenge.SharedElementTransitions.model.ElementModel

interface ElementClickListener {
    fun onElementClick(view: ImageView, element: ElementModel)
}