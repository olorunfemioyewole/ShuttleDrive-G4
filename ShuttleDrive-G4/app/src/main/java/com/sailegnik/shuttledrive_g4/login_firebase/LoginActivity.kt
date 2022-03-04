package com.sailegnik.shuttledrive_g4.login_firebase

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.sailegnik.shuttledrive_g4.MainActivity
import com.sailegnik.shuttledrive_g4.R
import com.sailegnik.shuttledrive_g4.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //view binding
    private lateinit var binding: ActivityLoginBinding
    //action bar
//    private lateinit var actionBar: ActionBar
    //progress dialog
    private lateinit var progressDialog: ProgressDialog
    //firebase Auth
    private lateinit var firebaseAuth: FirebaseAuth
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*configure action bar
        actionBar = supportActionBar!!
        actionBar.title = "Login"*/

        //configure progress dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setMessage("Logging in...")
        progressDialog.setCanceledOnTouchOutside(false)

        //init firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser();

        //handle register
        binding.signupprompt.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        //handle login
        binding.loginBn.setOnClickListener{
            //before logging in, validate data
            validateData()
        }

    }

    private fun validateData() {
        //get data
        email = binding.emailT.text.toString().trim()
        password = binding.passwordT.text.toString().trim()

        //validate data
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.emailT.error = "Invalid email format"
        }
        else if(TextUtils.isEmpty(password)){
            //no password entered
            binding.passwordT.error = "Please enter password"
        }
        else{
            //data is validated, begin login
            firebaseLogin()
        }
    }

    private fun firebaseLogin() {
        //show progress
        progressDialog.show()
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                progressDialog.dismiss()
                //get user info
                val firebaseUser = firebaseAuth.currentUser
                val email = firebaseUser!!.email
                Toast.makeText(this, "Logged in as $email", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener{ e->
                progressDialog.dismiss()
                Toast.makeText(this, "Login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        //if user is already logged in, go to profile activity
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if(firebaseUser != null){
            //user is already logged in
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }


}