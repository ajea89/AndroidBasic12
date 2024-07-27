package com.ajea.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidbasic12.R

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)

        btnSendActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Jose")
                putExtra("EXTRA_OPTION", true)
            }

            startActivity(intent)
        }
    }
}