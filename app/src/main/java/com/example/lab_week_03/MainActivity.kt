package com.example.lab_week_03

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Interface untuk komunikasi ListFragment → MainActivity
interface CoffeeListener {
    fun onSelected(id: Int)
}

class MainActivity : AppCompatActivity(), CoffeeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Pakai root LinearLayout/ConstraintLayout dengan id "main"
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Callback dari ListFragment kalau user klik salah satu item kopi
    override fun onSelected(id: Int) {
        val detailFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_detail) as DetailFragment
        detailFragment.setCoffeeData(id)
    }
}
