package com.sailegnik.shuttledrive_g4.cart

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sailegnik.shuttledrive_g4.MainActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.about.AboutActivity
import com.sailegnik.shuttledrive_g4.databinding.ActivityCartBinding
import com.sailegnik.shuttledrive_g4.ticket.TicketActivity

class CartActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)


        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //switching activity with bottom nav
        binding.bottomNav.setOnNavigationItemSelectedListener {
            it.isChecked = true

            when(it.itemId){
                R.id.home-> {val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)}
                R.id.ticket-> {val intent = Intent(this, TicketActivity::class.java)
                    startActivity(intent)}
                R.id.about-> {val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)}
//                R.id.cart-> {val intent = Intent(this, CartActivity::class.java)
//                    startActivity(intent)}
            }

            true
        }
    }
}