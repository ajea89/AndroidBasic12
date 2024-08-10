package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.fragment.params

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.databinding.ActivityParamsBinding

class ParamsActivity : AppCompatActivity() {

    private lateinit var bindind : ActivityParamsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindind = ActivityParamsBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentParams, SendParamsFragment.newInstance())
            .commit()

    }
}