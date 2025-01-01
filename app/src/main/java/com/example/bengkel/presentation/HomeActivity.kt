package com.example.bengkel.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bengkel.R


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)

        val buttonBengkel1 = findViewById<Button>(R.id.buttonBengkel1)
        val buttonBengkel2 = findViewById<Button>(R.id.buttonBengkel2)
        val buttonBengkel3 = findViewById<Button>(R.id.buttonBengkel3)

        val homeButton = findViewById<ImageButton>(R.id.HomeButton)
        val chatButton = findViewById<ImageButton>(R.id.ChatButton)
        val profileButton = findViewById<ImageButton>(R.id.ProfileButton)

        buttonBengkel1.setOnClickListener {
            val intent = Intent(this, TempatActivity::class.java)
            startActivity(intent)
        }

        buttonBengkel2.setOnClickListener {
            val intent = Intent(this, TempatActivity::class.java)
            startActivity(intent)
        }

        buttonBengkel3.setOnClickListener {
            val intent = Intent(this, TempatActivity::class.java)
            startActivity(intent)
        }

        homeButton.setOnClickListener {
        }

        chatButton.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        profileButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}
