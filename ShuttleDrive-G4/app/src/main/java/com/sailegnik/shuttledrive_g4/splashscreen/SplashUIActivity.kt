package com.sailegnik.shuttledrive_g4.splashscreen

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.intro.IntroActivity

class SplashUIActivity : AppCompatActivity() {
    //time before leaving the view
    private val SPLASH_UI_TIME_OUT:Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_uiactivity)

        // this takes of the status bar
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // delay the UI for <SPLASH_UI_TIME_OUT> milliseconds
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, IntroActivity::class.java))
            finish()
        }, SPLASH_UI_TIME_OUT)
    }
}