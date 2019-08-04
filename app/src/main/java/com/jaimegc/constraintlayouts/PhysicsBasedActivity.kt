package com.jaimegc.constraintlayouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.dynamicanimation.animation.DynamicAnimation
import androidx.dynamicanimation.animation.FlingAnimation
import androidx.dynamicanimation.animation.SpringAnimation
import kotlinx.android.synthetic.main.activity_physics_based.*

class PhysicsBasedActivity : AppCompatActivity() {

    private var animatedSpring = false
    private var animatedFling = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_physics_based)
    }

    fun onClickButton(view: View) {
        when(view.id) {
            R.id.buttonFlingAnimation -> setupFlingAnimation()
            R.id.buttonSpringPhysics -> setupSpringAnimation()
        }
    }

    private fun setupFlingAnimation() {
        if (!animatedFling){
            FlingAnimation(imageViewCat, DynamicAnimation.TRANSLATION_Y).apply {
                setStartVelocity(700f) // Pixels per second
                friction = 0.1f
            }.start()
        } else {
            FlingAnimation(imageViewCat, DynamicAnimation.TRANSLATION_Y).apply {
                setStartVelocity(-700f) // Pixels per second
                friction = 0.1f
            }.start()
        }
        animatedFling = !animatedFling
    }

    private fun setupSpringAnimation() {
        if (!animatedSpring){
            SpringAnimation(imageViewCat, DynamicAnimation.TRANSLATION_Y, 700f).apply {
                spring.stiffness = 60f
                spring.dampingRatio = 0.3f
            }.start()
        } else {
            SpringAnimation(imageViewCat, DynamicAnimation.TRANSLATION_Y, 0f).apply {
                spring.stiffness = 60f
                spring.dampingRatio = 0.3f
            }.start()
        }

        animatedSpring = !animatedSpring
    }
}
