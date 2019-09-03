package com.jaimegc.constraintlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class AnimationCodingInFlowCollapseExpandOtherActivity : AppCompatActivity() {

    private lateinit var layout: ConstraintLayout
    private val constraintSetCollapse = ConstraintSet()
    private val constraintSetExpand = ConstraintSet()
    private var isCollapsed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_coding_in_flow_expand_other)

        layout = findViewById(R.id.layout)

        constraintSetCollapse.clone(layout)
        constraintSetExpand.clone(this, R.layout.activity_animation_coding_in_flow_collapse_other)
    }

    fun changeView(view: View) {
        if (!isCollapsed) {
            TransitionManager.beginDelayedTransition(layout)
            constraintSetExpand.applyTo(layout)
            isCollapsed = true
        } else {
            collapse()
        }
    }

    fun changeViewFloating(view: View) {
        if (!isCollapsed) {
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(layout, changeBounds)
            constraintSetExpand.applyTo(layout)
            isCollapsed = true
        } else {
            collapseFloating()
        }
    }

    override fun onBackPressed() {
        if (isCollapsed) {
            collapseFloating()
        } else {
            super.onBackPressed()
        }
    }

    private fun collapse() {
        if (isCollapsed) {
            val changeBounds = ChangeBounds()
            //changeBounds.interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(layout, changeBounds)
            constraintSetCollapse.applyTo(layout)
            isCollapsed = false
        }
    }

    private fun collapseFloating() {
        if (isCollapsed) {
            val changeBounds = ChangeBounds()
            changeBounds.interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(layout, changeBounds)
            constraintSetCollapse.applyTo(layout)
            isCollapsed = false
        }
    }
}
