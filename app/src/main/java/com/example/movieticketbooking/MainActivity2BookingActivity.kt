package com.example.movieticketbooking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_booking)

        val seats = intent.getStringExtra("seats")
        val total = intent.getIntExtra("total", 0)
        val movie = intent.getStringExtra("movieName")

        val movieName = findViewById<TextView>(R.id.movieName)
        val seatInfo = findViewById<TextView>(R.id.seatInfo)
        val totalAmount = findViewById<TextView>(R.id.totalAmount)

        movieName.text = "🎬 $movie"
        seatInfo.text = "💺 Seats: $seats"
        totalAmount.text = "💰 Total: ₹$total"

        val confirmBtn = findViewById<Button>(R.id.confirmBtn)

        confirmBtn.setOnClickListener {

            android.app.AlertDialog.Builder(this)
                .setTitle("Confirm Booking")
                .setMessage("Do you want to confirm your tickets?")
                .setPositiveButton("Yes") { _, _ ->

                    val intent =
                        Intent(this, TicketActivity::class.java)

                    intent.putExtra("seats", seats)
                    intent.putExtra("total", total)
                    intent.putExtra("movieName", movie)

                    startActivity(intent)
                }
                .setNegativeButton("No", null)
                .show()
        }
    }
}