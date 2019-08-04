package com.jaimegc.constraintlayouts

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

import android.util.Pair as Pair

class OtherSameActivity : AppCompatActivity() {

    private var isOpen = false
    private lateinit var layout1: ConstraintSet
    private lateinit var layout2: ConstraintSet
    private lateinit var constraintLayout: ConstraintLayout
    private lateinit var imageBackground: ImageView
    private lateinit var photo: ImageView
    private lateinit var goProfile: Button
    private lateinit var name: TextView
    private lateinit var city: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_same)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        layout1 = ConstraintSet()
        layout2 = ConstraintSet()
        constraintLayout = findViewById(R.id.constraint_layout)
        imageBackground = findViewById(R.id.image_background)
        photo = findViewById(R.id.photo)
        goProfile = findViewById(R.id.go_profile)
        name = findViewById(R.id.name)
        city = findViewById(R.id.city)

        layout2.clone(this, R.layout.activity_other_expanded)
        layout1.clone(constraintLayout)

        photo.setOnClickListener {
            if (!isOpen) {
                TransitionManager.beginDelayedTransition(constraintLayout)
                layout2.applyTo(constraintLayout)
            } else {
                TransitionManager.beginDelayedTransition(constraintLayout)
                layout1.applyTo(constraintLayout)
            }

            isOpen = !isOpen
        }

        goProfile.setOnClickListener {

            val sharedIntent = Intent(this, OtherProfileSameActivity::class.java)

            val activityOptions = ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create<View, String>(photo, photo.transitionName),
                Pair.create<View, String>(name, name.transitionName),
                Pair.create<View, String>(city, city.transitionName))

            startActivity(sharedIntent, activityOptions.toBundle())
        }
    }
}
