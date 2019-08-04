package com.jaimegc.constraintlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class AnimationCodingInFlowCollapseExpandActivity : AppCompatActivity() {

    private lateinit var layout: ConstraintLayout
    private val constraintSetCollapse = ConstraintSet()
    private val constraintSetExpand = ConstraintSet()
    private var isExpanded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_coding_in_flow_collapse)

        layout = findViewById(R.id.layout)

        constraintSetCollapse.clone(layout)
        constraintSetExpand.clone(this, R.layout.activity_animation_coding_in_flow_expand)
    }

    fun expandView(view: View) {
        if (!isExpanded) {
            TransitionManager.beginDelayedTransition(layout)
            constraintSetExpand.applyTo(layout)
            isExpanded = true
        } else {
            collapse()
        }
    }

    fun collapseView(view: View) {
        collapse()
    }

    override fun onBackPressed() {
        if (isExpanded) {
            collapse()
        } else {
            super.onBackPressed()
        }
    }

    private fun collapse() {
        if (isExpanded) {
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(layout, changeBounds)
            constraintSetCollapse.applyTo(layout)
            isExpanded = false
        }
    }
}
