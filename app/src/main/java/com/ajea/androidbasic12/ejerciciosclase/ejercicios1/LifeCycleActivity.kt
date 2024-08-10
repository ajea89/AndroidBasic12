package com.ajea.androidbasic12.ejerciciosclase.ejercicios1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.databinding.ActivityMainBinding

class LifeCycleActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("LifeCycle", "onCreate")
        Toast.makeText(this,"onCreate", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.e("LifeCycle", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("LifeCycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("LifeCycle", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("LifeCycle", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("LifeCycle", "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.e("LifeCycle", "onRestart")
    }
}