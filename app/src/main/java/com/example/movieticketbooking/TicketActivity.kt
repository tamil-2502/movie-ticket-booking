package com.example.movieticketbooking

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TicketActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        val details = findViewById<TextView>(R.id.finalDetails)

        val seats = intent.getStringExtra("seats")
        val total = intent.getIntExtra("total", 0)
        val movie = intent.getStringExtra("movieName")

        details.text =
            "🎬 $movie\n\n💺 $seats\n\n💰 ₹$total"
    }
}