package com.example.movieticketbooking

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movies = arrayOf(
            "GHILLI",
            "THERI",
            "LEO",
            "THUPPAKKI",
            "MERSAL",
            "JILLA",
            "MASTER"
        )

        val listView = findViewById<ListView>(R.id.movieList)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            movies
        )

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, MovieDetailsActivity::class.java)
            intent.putExtra("movieName", movies[position])
            startActivity(intent)
        }
    }
}