package com.sailegnik.shuttledrive_g4.booking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.data.ShuttleData

class BookingListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    /*private lateinit var from*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("AM Learners")

        recyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val BookingList = ArrayList<ShuttleData>()

        /*BookingList.add(
            ""
        )*/
    }
}