package com.sailegnik.shuttledrive_g4.login_firebase

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivitySignUpBinding
    //action bar
    private lateinit var actionBar: ActionBar
    //progressDialog
    private lateinit var progressDialog: ProgressDialog
    //firebaseAuth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //configure ActionBar //enable back button
        /*actionBar = supportActionBar!!
        actionBar.title = "Sign Up"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)*/

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Creating Account...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        //handle click, begin signup
        binding.signupBn.setOnClickListener {
            //validate data
            validateData()
        }
    }

    private fun validateData() {
        //get data
        email = binding.emailT.text.toString().trim()
        password = binding.passwordT.text.toString().trim()
        //validate data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid format
            binding.emailT.error = "Invalid email"
        }
        else if(TextUtils.isEmpty(password)){
        //invalid format
        binding.passwordT.error = "Please enter password"
        }
        else if(password.length <6){
            //password length 6 char
            binding.passwordT.error = "Password must be atleast 6 characters long"
        }
        else{
            //data is valid, sign up
            firebaseSignUp()
        }

    }

    private fun firebaseSignUp() {
        //show progress
        progressDialog.show()

        //create account
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                //signup success
                progressDialog.dismiss()
                //get current user
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this,"Account created with email $email", Toast.LENGTH_SHORT).show()

                //open profile
                startActivity(Intent(this,ProfileActivity::class.java))
                finish()
            }
            .addOnFailureListener{e ->
                Toast.makeText(this,"SignUp failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()//go back to previous activity
        return super.onSupportNavigateUp()
    }
}