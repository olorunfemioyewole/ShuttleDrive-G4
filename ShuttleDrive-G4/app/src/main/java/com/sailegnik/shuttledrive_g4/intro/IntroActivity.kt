package com.sailegnik.shuttledrive_g4.intro

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.sailegnik.shuttledrive_g4.MainActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.utils.IntroSlides.introSliderAdapter

class IntroActivity : AppCompatActivity() {
    private lateinit var introSliderViewPager : ViewPager2
    private lateinit var btnNext: Button

    private lateinit var textSkipIntro : TextView
    private lateinit var indicatorsContainer : LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }



        introSliderViewPager = findViewById(R.id.introSliderViewPager)
        btnNext = findViewById(R.id.btnNext)
        introSliderViewPager.adapter = introSliderAdapter
        textSkipIntro = findViewById(R.id.textSkipIntro)
        indicatorsContainer = findViewById(R.id.indicatorsContainer)

        setupIndicators()
        setCurrentIndicators(0)

        introSliderViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicators(position)
            }
        })

        btnNext.setOnClickListener {
            if (introSliderViewPager.currentItem + 1 < introSliderAdapter.itemCount) {
                introSliderViewPager.currentItem +=1
            }else{
                Intent(applicationContext, MainActivity::class.java).also {
                    startActivity(it)
                }
            }
        }

        textSkipIntro.setOnClickListener {
            Intent(applicationContext, MainActivity::class.java).also {
                startActivity(it)
            }
        }

    }



    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(size = introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

        layoutParams.setMargins(8, 0, 8, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicatorsContainer.addView(indicators[i])

        }
    }

    private fun setCurrentIndicators(index : Int) {
        val childCount = indicatorsContainer.childCount
        for (i in 0 until childCount) {
            val imageView =
                indicatorsContainer[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }

}