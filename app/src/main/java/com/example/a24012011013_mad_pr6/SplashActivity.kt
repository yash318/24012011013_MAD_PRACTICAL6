package com.example.a24012011013_mad_pr6

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() , Animation.AnimationListener{
    lateinit var guniframeanimation : AnimationDrawable
    lateinit var imglogo : ImageView
    lateinit var guniAnimation: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        imglogo = findViewById(R.id.imglogo)
        imglogo.setBackgroundResource(R.drawable.uvpce_animation_list)
        guniframeanimation = imglogo.background as AnimationDrawable
        guniAnimation = AnimationUtils.loadAnimation(this,R.anim.twin_animation)
        guniAnimation.setAnimationListener(this)
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus){
            guniframeanimation.start()
            imglogo.startAnimation(guniAnimation)
        }else {
            guniframeanimation.stop()
        }
    }

    override fun onAnimationEnd(animation: Animation?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    override fun onAnimationRepeat(animation: Animation?) {

    }

    override fun onAnimationStart(animation: Animation?) {

    }

}
