package com.sailegnik.shuttledrive_g4.booking

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.adapter.ShuttleAdapter
import com.sailegnik.shuttledrive_g4.data.ShuttleData
import com.sailegnik.shuttledrive_g4.utils.ShuttleImg.shuttleimg
import com.sailegnik.shuttledrive_g4.utils.ShuttleImg.shuttleimg2

class BookingListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_list)

        recyclerView = findViewById(R.id.recView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val intent = getIntent();
        val From = intent.getStringExtra("From")
        val To = intent.getStringExtra("To")
        val Date = intent.getStringExtra("Date")

        val BookingList = ArrayList<ShuttleData>()

        BookingList.add(
            ShuttleData("Shuttle 01","From: $From","To: $To","Date: $Date","Fare: GHc 800.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC",shuttleimg)
        )
        BookingList.add(
            ShuttleData("Shuttle 02","From: $From","To: $To","Date: $Date","Fare: GHc 1000.00",
                "Time: 10am",0,0,false,false,"Type: AC",shuttleimg)
        )
        BookingList.add(
            ShuttleData("Shuttle 03","From: $From","To: $To","Date: $Date","Fare: GHc 900.00",
                "Time: 10am",0,0,false,false,"Type: Non-AC",shuttleimg2)
        )
        BookingList.add(
            ShuttleData("Shuttle 04","From: $From","To: $To","Date: $Date","Fare: GHc 1100.00",
                "Time: 10am",0,0,false,false,"Type: AC",shuttleimg2)
        )

        val adapter = ShuttleAdapter(this,BookingList, object : ShuttleAdapter.HandleShuttleClick {
            override fun onLearnerClick(position: Int) {
                val shuttle = BookingList[position]
                val name:String = shuttle.name
                val fromLoc: String = shuttle.fromLoc
                val toLoc: String = shuttle.toLoc
                val date :String = shuttle.date
                val time :String = shuttle.time
                val fare :String = shuttle.fare
                val type :String = shuttle.AC
                val shuttleImg: Int = shuttle.img


                val intent = Intent(this@BookingListActivity, BookingActivity::class.java)
                intent.putExtra("name",name)
                intent.putExtra("fromLoc",fromLoc)
                intent.putExtra("toLoc",toLoc)
                intent.putExtra("date",date)
                intent.putExtra("time",time)
                intent.putExtra("fare",fare)
                intent.putExtra("type",type)
                intent.putExtra("shuttleimg",shuttleImg)
                startActivity(intent)
            }
        })

        recyclerView.adapter = adapter
    }
}