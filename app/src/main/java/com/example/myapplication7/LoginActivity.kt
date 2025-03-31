package com.example.myapplication7
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button

    private val credentialSharedPref = "our_shared_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edUsername = findViewById(R.id.ed_username)
        edPassword = findViewById(R.id.ed_password)
        btnLogin = findViewById(R.id.btn_login)
        btnSignUp = findViewById(R.id.btn_signup)

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val credentials = getSharedPreferences(credentialSharedPref, Context.MODE_PRIVATE)
            val strUsername = credentials.getString("Username", null)
            val strPassword = credentials.getString("Password", null)

            val usernameFromEd = edUsername.text.toString()
            val passwordFromEd = edPassword.text.toString()

            if (strUsername != null && usernameFromEd.equals(strUsername, ignoreCase = true)) {
                if (strPassword != null && passwordFromEd.equals(strPassword, ignoreCase = true)) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

