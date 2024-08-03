package com.ajea.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val labeName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        //Se leen los extras que llegan de HomeActivity o ThirdActivity
        intent.extras?.let { extras ->
            if (extras.containsKey("EXTRA_NAME_KEY")){
                val name = extras.getString("EXTRA_NAME_KEY", "")
//                labeName.text = name
            }

            if (extras.containsKey("EXTRA_AGE_KEY")) {
                val age = extras.getInt("EXTRA_AGE_KEY", 0)
                Toast.makeText(this, "Mi edad es: $age", Toast.LENGTH_LONG).show()
            }

            if (extras.containsKey("EXTRA_OPTION")){
                val option = extras.getBoolean("EXTRA_OPTION", false)
                Toast.makeText(this, "Mi opcion es: $option", Toast.LENGTH_LONG).show()
            }

            if (extras.containsKey("EXTRA_MORE_INFO")){
                //Se obtiene bundle
                val extraInfo = extras.getBundle("EXTRA_MORE_INFO")

                //Del bundle obtenido se saca información
                val surname = extraInfo?.getString("EXTRA_SURNAME", "")
                val isMarried = extraInfo?.getBoolean("EXTRA_MARRIED")

                labeName.text = "Surname: $surname, married: ${if (isMarried == true) "yes" else "No"}"
            }
        }

        //Forma corta de obtener extras
//        val name = intent.getStringExtra("EXTRA_NAME_KEY")
//        val age = intent.getIntExtra("EXTRA_AGE_KEY", 0)
//        val option = intent.getBooleanExtra("EXTRA_OPTION", false)
//
//        name?.let {
//            labeName.text = name
//        }

        btnReturn.setOnClickListener {
            //Se envia result ok y dato mediante el intent a HomeActivity
            val resultIntent = Intent().apply {
                putExtra("EXTRA_IS_CORRECT_KEY", true)
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home ->{
                onBackPressedDispatcher.onBackPressed()
//                Toast.makeText(this, "Click en back", Toast.LENGTH_SHORT).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }
}