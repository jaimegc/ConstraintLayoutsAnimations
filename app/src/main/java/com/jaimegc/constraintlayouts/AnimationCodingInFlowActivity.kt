package com.jaimegc.constraintlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Placeholder

class AnimationCodingInFlowActivity : AppCompatActivity() {

    private lateinit var placeholder: Placeholder
    private lateinit var layout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_coding_in_flow)

        placeholder = findViewById(R.id.placeholder)
        layout = findViewById(R.id.layout)
    }

    fun swapView(view: View) {
        TransitionManager.beginDelayedTransition(layout)
        placeholder.setContentId(view.id)
    }
}