package com.example.android.myloginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.android.myloginapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.loginButton?.setOnClickListener { loginButtonSetUp() }
        binding?.cancelButton?.setOnClickListener { cancelButtonSetup() }
    }

    private fun loginButtonSetUp() {
        val userNameInTextField = binding?.usernameEditText?.text.toString().trim()
        val passwordInTextField = binding?.passwordEditText?.text.toString().trim()
        val username = "zuri"
        val password = "android"

        if (userNameInTextField.isEmpty() || passwordInTextField.isEmpty() &&
                userNameInTextField != username || passwordInTextField != password) {
            Toast.makeText(this, "Please Input the Correct Username and Password",
                    Toast.LENGTH_SHORT).show()
            return
        } else if (userNameInTextField == username && passwordInTextField == password) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun cancelButtonSetup() {
        binding?.usernameEditText?.text?.clear()
        binding?.passwordEditText?.text?.clear()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}