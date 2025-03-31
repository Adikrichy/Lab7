package com.example.myapplication7

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var edUsername: EditText
    private lateinit var edPassword: EditText
    private lateinit var edConfirmPassword: EditText
    private lateinit var btnCreateUser: Button

    private val credentialSharedPref = "our_shared_pref"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        edUsername = findViewById(R.id.ed_username)
        edPassword = findViewById(R.id.ed_password)
        edConfirmPassword = findViewById(R.id.ed_confirm_pwd)
        btnCreateUser = findViewById(R.id.btn_create_user)

        btnCreateUser.setOnClickListener {
            val strUsername = edUsername.text.toString().trim()
            val strPassword = edPassword.text.toString().trim()
            val strConfirmPassword = edConfirmPassword.text.toString().trim()

            when {
                // Проверка пустых полей
                strUsername.isEmpty() -> {
                    edUsername.error = "Введите имя"
                    return@setOnClickListener
                }
                strPassword.isEmpty() -> {
                    edPassword.error = "Введите пароль"
                    return@setOnClickListener
                }
                strConfirmPassword.isEmpty() -> {
                    edConfirmPassword.error = "Подтвердите пароль"
                    return@setOnClickListener
                }

                // Проверка совпадения паролей (с учетом регистра)
                strPassword != strConfirmPassword -> {
                    edConfirmPassword.error = "Пароли должны совпадать"
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show()
                }

                // Успешная регистрация
                else -> {
                    saveCredentials(strUsername, strPassword)
                    Toast.makeText(this, "Успешная регистрация!", Toast.LENGTH_SHORT).show()

                    // Закрытие через 1.5 секунды
                    Handler(Looper.getMainLooper()).postDelayed({
                        finish()
                    }, 1500)
                }
            }
        }
    }

    private fun saveCredentials(username: String, password: String) {
        getSharedPreferences(credentialSharedPref, Context.MODE_PRIVATE).edit()
            .putString("Username", username)
            .putString("Password", password)
            .apply()
    }
}