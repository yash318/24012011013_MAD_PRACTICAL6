package com.example.a24012011013_mad_pr6

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class
MainActivity : AppCompatActivity() , Animation.AnimationListener {
    lateinit var clockAnimation: AnimationDrawable
    lateinit var heartAnimation: AnimationDrawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            clockAnimation = findViewById<ImageView>(R.id.img1).background as
                    AnimationDrawable
            heartAnimation = findViewById<ImageView>(R.id.img2).background as
                    AnimationDrawable
            clockAnimation.start()
            heartAnimation.start()
        } else {
            clockAnimation.stop()
            heartAnimation.stop()
        }
    }
    override fun onAnimationStart(animation: Animation?) {
        Log.d("AnimationStart", "Animation started")
    }
    override fun onAnimationEnd(animation: Animation?) {
        Log.d("AnimationEnd", "Animation ended")
        clockAnimation.start()
    }
    override fun onAnimationRepeat(animation: Animation?) {
        Log.d("AnimationRepeat", "Animation has repeated")
    }
}
