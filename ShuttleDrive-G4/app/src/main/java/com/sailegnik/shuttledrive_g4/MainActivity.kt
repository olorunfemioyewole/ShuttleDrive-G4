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
    private lateinit var returnDate: Button
    private lateinit var tvJourneyDate: TextView
    private lateinit var tvReturnDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //date picker
        journeyDate = findViewById(R.id.journey_date)
        tvJourneyDate = findViewById(R.id.tv_journey_date)
        returnDate = findViewById(R.id.return_date)
        tvReturnDate = findViewById(R.id.tv_return_date)

        val myCalendar = Calendar.getInstance()

        val datePickerJ = DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateJourney(myCalendar)
        }
        val datePickerR = DatePickerDialog.OnDateSetListener{view, year,month,dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, month)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateReturn(myCalendar)
        }

        journeyDate.setOnClickListener{
            DatePickerDialog(this, datePickerJ, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        returnDate.setOnClickListener{
            DatePickerDialog(this, datePickerR, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }


    }

    private fun updateJourney(myCalendar: Calendar){
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvJourneyDate.setText(sdf.format(myCalendar.time))
    }

    private fun updateReturn(myCalendar: Calendar){
        val myFormat = "dd-MM-yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.UK)
        tvReturnDate.setText(sdf.format(myCalendar.time))
    }


}