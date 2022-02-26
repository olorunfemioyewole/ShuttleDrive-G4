package com.sailegnik.shuttledrive_g4.utils

import com.sailegnik.shuttledrive_g4.intro.IntroAdapter
import com.sailegnik.shuttledrive_g4.intro.IntroSlide

object IntroSlides {
        val introSliderAdapter = IntroAdapter(
            listOf(
                IntroSlide(
                    "Seat Allocation",
                    "Get to know where you'd be seating in a bus even before arrival at the terminal and."
                ),
                IntroSlide(
                    "Hostel Pickups",
                    "Book buses easily and conveniently for trips for yourself and friends or school mates from campus"
                ),
                IntroSlide(
                    "Track Bus Location",
                    "Find out where bus is at the moment to track live location of your loved ones"
                )
            )
        )
    }