package com.sailegnik.shuttledrive_g4

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var journeyDate: Button
    private lateinit var tvjourneyDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        journeyDate = findViewById(R.id.journey_date)
        tvjourneyDate = findViewById(R.id.tv_journey_date)

        val Calendar = Calendar.getInstance()

        val datePicker = DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->
            Calendar.set(Calendar.YEAR, year)
            Calendar.set(Calendar.MONTH, month)
            Calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateLable(Calendar)
        }

        journeyDate.setOnClickListener{
            DatePickerDialog(this, datePicker, Calendar.get(Calendar.YEAR), Calendar.get(Calendar.MONTH),
            Calendar.get(Calendar.DAY_OF_MONTH)).show()
        }


    }

    private fun updateLable(myCalendar: Calendar){
        val myFormat = "dd-mm-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvjourneyDate.setText(sdf.format(myCalendar.time))
    }


}