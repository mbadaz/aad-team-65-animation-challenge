package com.mambure.aad_team_65_animation_challenge.widgets

import android.annotation.TargetApi
import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

/**
 * This will create a square frame layout. (Custom View)
 * Good for drawing items in a grid to fit a square.
 *
 * @author KudzieChase
 */
class WidthFitSquareLayout : FrameLayout {
    private var forceSquare = true

    constructor(context: Context) : super(context)

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)

    constructor(context: Context, attributeSet: AttributeSet, i: Int) : super(context, attributeSet, i)

    @TargetApi(21)
    constructor(context: Context, attributeSet: AttributeSet, i: Int, i2: Int) : super(context, attributeSet, i, i2)

    override fun onMeasure(i: Int, i2: Int) {
        var height = i2
        if (this.forceSquare) {
            height = i
        }
        super.onMeasure(i, height)
    }
}