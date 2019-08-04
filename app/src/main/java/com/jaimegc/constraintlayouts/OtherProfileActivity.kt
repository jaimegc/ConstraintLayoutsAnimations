package com.jaimegc.constraintlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.jaimegc.constraintlayouts.utils.EnterSharedElementCallback
import com.jaimegc.constraintlayouts.utils.TransitionUtils

class OtherProfileActivity : AppCompatActivity() {

    private lateinit var photo: ImageView
    private lateinit var name: TextView
    private lateinit var city: TextView
    private lateinit var text: TextView
    private lateinit var back: Button
    private lateinit var imageBottom: ImageView
    private lateinit var animation1: Animation
    private lateinit var animation2: Animation
    private lateinit var animation3: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_profile)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        photo = findViewById(R.id.photo)
        name = findViewById(R.id.name)
        city = findViewById(R.id.city)
        text = findViewById(R.id.text)
        back = findViewById(R.id.back)
        imageBottom = findViewById(R.id.image_bottom)

        window.enterTransition = TransitionUtils.makeEnterTransition()
        window.sharedElementEnterTransition = TransitionUtils.makeSharedElementEnterTransition(this)
        setEnterSharedElementCallback(EnterSharedElementCallback(this))

        animation1 = AnimationUtils.loadAnimation(this, R.anim.alpha_to_go1)
        animation2 = AnimationUtils.loadAnimation(this, R.anim.alpha_to_go2)
        animation3 = AnimationUtils.loadAnimation(this, R.anim.alpha_to_go3)

        text.startAnimation(animation1)
        imageBottom.startAnimation(animation2)
        back.startAnimation(animation3)

        back.setOnClickListener { onBackPressed() }
    }
}
