package com.jaimegc.constraintlayouts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickButton(view: View) {
        var intent: Intent? = null

        when(view.id) {
            R.id.cats -> intent = Intent(this, CatsLandscapeActivity::class.java)
            R.id.profile -> intent = Intent(this, ProfileActivity::class.java)
            R.id.aspect_ratio -> intent = Intent(this, AspectRatioActivity::class.java)
            R.id.profile_transition_same -> intent = Intent(this, OtherSameActivity::class.java)
            R.id.profile_transition_different -> intent = Intent(this, OtherActivity::class.java)
            R.id.exchange -> intent = Intent(this, AnimationCodingInFlowActivity::class.java)
            R.id.collapse_expand -> intent = Intent(this, AnimationCodingInFlowCollapseExpandActivity::class.java)
            R.id.lottie -> intent = Intent(this, LottieActivity::class.java)
            R.id.physics_based -> intent = Intent(this, PhysicsBasedActivity::class.java)
            R.id.collapse_expand_other -> intent = Intent(this, AnimationCodingInFlowCollapseExpandOtherActivity::class.java)
        }

        intent?.let {
            startActivity(intent)
        }
    }
}
