package com.ajea.androidbasic12.ejerciciosclase.ejercicios1.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class HomeActivity : AppCompatActivity() {

    //Se crea register para obtener el resultado de SecondActivity
    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false)
            if (isCorrect == true){
                onBackPressedDispatcher.onBackPressed()
            }else{
                Toast.makeText(this, "resultExtra= $isCorrect", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)

        //Se envia extras a SecondActivity, si se desea obtener un result de la actividad se ocupa el register (register.launch(intent))
        //Si no se desea obtener un result se ocupa startActivity(intent)
        btnSendActivity.setOnClickListener {

            //Se crea un bundle con infomación extra y se envia bundle como extra en intent
            val extraBundle = Bundle().apply {
                putString("EXTRA_SURNAME", "Espinosa")
                putBoolean("EXTRA_MARRIED", false)
            }

            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME_KEY", "Alan")
                putExtra("EXTRA_AGE_KEY", 34)
                putExtra("EXTRA_MORE_INFO", extraBundle)
            }
            register.launch(intent)
//            startActivity(intent)
        }
    }
}