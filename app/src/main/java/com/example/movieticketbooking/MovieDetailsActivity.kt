package com.example.movieticketbooking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieName = intent.getStringExtra("movieName")

        val title = findViewById<TextView>(R.id.movieTitle)
        title.text = movieName

        val btn = findViewById<Button>(R.id.selectSeatBtn)

        btn.setOnClickListener {
            val intent = Intent(this, SeatSelectionActivity::class.java)
            intent.putExtra("movieName", movieName)
            startActivity(intent)
        }
    }
}