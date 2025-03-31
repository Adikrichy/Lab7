//package com.example.myapplication7
//import android.content.Context
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//
//class MainActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val etUsername = findViewById<EditText>(R.id.etUsername)
//        val etEmail = findViewById<EditText>(R.id.etEmail)
//        val btnSave = findViewById<Button>(R.id.btnSave)
//        val btnLoad = findViewById<Button>(R.id.btnLoad)
//        val tvResult = findViewById<TextView>(R.id.tvResult)
//
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//
//        btnSave.setOnClickListener {
//            val username = etUsername.text.toString()
//            val email = etEmail.text.toString()
//
//            val editor = sharedPreferences.edit()
//            editor.putString("USERNAME", username)
//            editor.putString("EMAIL", email)
//            editor.apply()
//
//            etUsername.text.clear()
//            etEmail.text.clear()
//        }
//
//        btnLoad.setOnClickListener {
//            val username = sharedPreferences.getString("USERNAME", "No username saved")
//            val email = sharedPreferences.getString("EMAIL", "No email saved")
//            tvResult.text = "Username: $username\nEmail: $email"
//        }
//    }
//}
//
