package com.example.myapplication7
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var edConfirmPassword: EditText
    private lateinit var btnCreateUser: Button

    private val CREDENTIAL_SHARED_PREF = "our_shared_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        edUsername = findViewById(R.id.ed_username)
        edPassword = findViewById(R.id.ed_password)
        edConfirmPassword = findViewById(R.id.ed_confirm_pwd)
        btnCreateUser = findViewById(R.id.btn_create_user)

        btnCreateUser.setOnClickListener {
            val username = edUsername.text.toString()
            val password = edPassword.text.toString()
            val confirmPassword = edConfirmPassword.text.toString()

            if (password == confirmPassword) {
                val credentials = getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE).edit()
                credentials.putString("Username", username)
                credentials.putString("Password", password)
                credentials.apply()

                Toast.makeText(this, "User Registered!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
