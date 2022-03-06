package com.sailegnik.shuttledrive_g4.payment

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {
    private lateinit var tvPreg:TextView
    private lateinit var tvDisa:TextView
    private lateinit var tvFare:TextView
    private lateinit var binding:ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tvDisa = findViewById(R.id.disabled)
        tvPreg = findViewById(R.id.pregnant)
        tvFare = findViewById(R.id.fare)

        val intent = getIntent()
        val pregnant = intent.getStringExtra("pregnant")
        val disabled = intent.getStringExtra("disabled")
        val fare = intent.getStringExtra("fare")

        tvPreg.text = pregnant
        tvDisa.text = disabled
        tvFare.text = fare

        binding.confirmPayBn.setOnClickListener{
            val intent = Intent(this, PaymentMethActivity::class.java)
            intent.putExtra("fare",tvFare.text)
            startActivity(intent)
        }
    }
}