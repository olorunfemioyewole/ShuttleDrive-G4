package com.sailegnik.shuttledrive_g4.booking

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.sailegnik.shuttledrive_g4.MainActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.about.AboutActivity
import com.sailegnik.shuttledrive_g4.cart.CartActivity
import com.sailegnik.shuttledrive_g4.databinding.ActivityBookingBinding
import com.sailegnik.shuttledrive_g4.login_firebase.ProfileActivity
import com.sailegnik.shuttledrive_g4.ticket.TicketActivity

class BookingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBookingBinding
    lateinit var toggle:ActionBarDrawerToggle
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar)

        //drawer toggle
        toggle = ActionBarDrawerToggle(this,binding.drawerLB,toolbar,R.string.openDrawer,R.string.closeDrawer)
        binding.drawerLB.addDrawerListener(toggle)
        toggle.syncState()

        //implementing drop down list for seats
        val seats = resources.getStringArray(R.array.seats)
        val seatArrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, seats)
        binding.adult.setAdapter(seatArrayAdapter)
        binding.child.setAdapter(seatArrayAdapter)
        binding.infant.setAdapter(seatArrayAdapter)

        //implementing drop down list for disabled/pregnant
        val care = resources.getStringArray(R.array.care)
        val careArrayAdapter = ArrayAdapter(this, R.layout.drop_down_item, care)
        binding.diabled.setAdapter(careArrayAdapter)
        binding.pregnant.setAdapter(careArrayAdapter)



        //switching activity with drawer
        binding.navViewB.setNavigationItemSelectedListener {
            it.isChecked = true

            when(it.itemId){
                R.id.home-> {val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)}
                R.id.ticket-> {val intent = Intent(this, TicketActivity::class.java)
                    startActivity(intent)}
                R.id.about-> {val intent = Intent(this, AboutActivity::class.java)
                    startActivity(intent)}
                R.id.cart-> {val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)}
                R.id.profile-> {val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)}
            }

            true
        }
    }
}