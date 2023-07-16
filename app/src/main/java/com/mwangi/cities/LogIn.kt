package com.mwangi.cities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mwangi.cities.databinding.ActivityLogInBinding

class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLogInBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btLogIn.setOnClickListener {
            logInUser()
        }

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
    }

    fun logInUser(){
        val email = binding.etLogInEmail.text.toString()
        val password = binding.etLogInPassword.text.toString()
        var error = false

        if (email.isBlank()){
            binding.tilLogInEmail.error = "Email Address cannot be empty"
            error = true
        }
        else{
            binding.tilLogInEmail.error = null
        }

        if (password.isBlank()){
            binding.tilLogInPassword.error = "Password cannot be empty"
        }
        else{
            binding.tilLogInPassword.error = null
        }

        if (!error){
//            Toast.makeText(this, "Log In Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
        }
    }
}