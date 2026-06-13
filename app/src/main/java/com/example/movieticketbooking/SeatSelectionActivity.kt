package com.example.movieticketbooking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SeatSelectionActivity : AppCompatActivity() {

    private val pricePerSeat = 150
    private val selectedSeats = mutableListOf<String>()
    private val bookedSeats = mutableSetOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val totalText = findViewById<TextView>(R.id.totalPrice)
        val bookBtn = findViewById<Button>(R.id.bookBtn)

        bookBtn.isEnabled = false

        val seats = listOf(
            findViewById<Button>(R.id.A1),
            findViewById<Button>(R.id.A2),
            findViewById<Button>(R.id.A3),
            findViewById<Button>(R.id.A4),
            findViewById<Button>(R.id.A5),
            findViewById<Button>(R.id.B1),
            findViewById<Button>(R.id.B2),
            findViewById<Button>(R.id.B3),
            findViewById<Button>(R.id.B4),
            findViewById<Button>(R.id.B5)
        )

        for (seat in seats) {

            seat.setOnClickListener {

                val seatName = seat.text.toString()

                if (bookedSeats.contains(seatName))
                    return@setOnClickListener

                if (seat.isSelected) {

                    seat.setBackgroundResource(R.drawable.seat_available)
                    seat.isSelected = false
                    selectedSeats.remove(seatName)

                } else {

                    seat.setBackgroundResource(R.drawable.seat_selected)
                    seat.isSelected = true
                    selectedSeats.add(seatName)
                }

                val total = selectedSeats.size * pricePerSeat
                totalText.text = "Total: ₹$total"

                bookBtn.isEnabled = selectedSeats.isNotEmpty()
            }
        }

        bookBtn.setOnClickListener {

            for (seat in selectedSeats) {

                bookedSeats.add(seat)

                val seatButton = seats.find {
                    it.text.toString() == seat
                }

                seatButton?.setBackgroundResource(R.drawable.seat_booked)
                seatButton?.isSelected = false
            }

            val movieName =
                intent.getStringExtra("movieName") ?: "Unknown Movie"

            val total = selectedSeats.size * pricePerSeat

            val bookingIntent =
                Intent(this, MainActivity2BookingActivity::class.java)

            bookingIntent.putExtra(
                "seats",
                selectedSeats.joinToString(", ")
            )

            bookingIntent.putExtra("total", total)
            bookingIntent.putExtra("movieName", movieName)

            selectedSeats.clear()
            bookBtn.isEnabled = false

            startActivity(bookingIntent)
        }
    }
}