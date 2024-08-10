package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.databinding.ActivityViewBindingExampleBinding

class ViewBindingExampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewBindingExampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBindingExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvFinal.text = "Texto final"
        binding.tvName.text = "Alan"
        binding.tvSurname.text = "Espinosa"
        binding.tvLastname.text = "Anaya"
    }
}