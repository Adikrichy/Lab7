package com.example.myapplication7

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.*

class MainActivity : AppCompatActivity() {
    private lateinit var tvData: TextView

    companion object {
        const val REQUEST_CODE_WRITE_PERM = 401
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvData = findViewById(R.id.tvData)

        val btnWriteFile: Button = findViewById(R.id.btnWriteFile)
        val btnReadFile: Button = findViewById(R.id.btnReadFile)

        btnWriteFile.setOnClickListener {
            writeFile("Hello: ${System.currentTimeMillis()}")
        }

        btnReadFile.setOnClickListener {
            tvData.text = readFile()
        }

        requestNeededPermission()
    }

    private fun requestNeededPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE_WRITE_PERM)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode == REQUEST_CODE_WRITE_PERM) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Permission NOT granted", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun writeFile(data: String) {
        val file = File(Environment.getExternalStorageDirectory(), "test.txt")

        try {
            FileOutputStream(file).use { it.write(data.toByteArray()) }
            Toast.makeText(this, "File written to ${file.absolutePath}", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun readFile(): String {
        val file = File(Environment.getExternalStorageDirectory(), "test.txt")

        return if (file.exists()) {
            file.readText()
        } else {
            "File not found"
        }
    }
}
