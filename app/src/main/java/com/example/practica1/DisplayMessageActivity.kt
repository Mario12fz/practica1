package com.example.practica1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val exitButton = findViewById<ImageButton>(R.id.exitButton)

        exitButton.setOnClickListener{
            finish()
        }
        // Capturamos el valor pasado del mainActivity

        val message = intent.getStringExtra(EXTRA_MESSAGE)



        //  Asiganamos el valor al textView
        val tvResult = findViewById<TextView>(R.id.tvMessage).apply {
            text = message
        }
    }
}