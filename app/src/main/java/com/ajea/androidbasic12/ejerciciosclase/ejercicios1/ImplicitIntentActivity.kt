package com.ajea.androidbasic12.ejerciciosclase.ejercicios1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.databinding.ActivityImplicitIntentBinding

class ImplicitIntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        //Se generan instancias de botones
        val btnSent = findViewById<Button>(R.id.btnSend)
        val btnSendUrl = findViewById<Button>(R.id.btnSendUrl)

        //Se detecta click de boton y se envia intent implicito para envias correo
        btnSent.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Aviso Urgente")
                putExtra(Intent.EXTRA_TEXT, "Este es un mensaje prueba de email.")
            }

            startActivity(Intent.createChooser(emailIntent, "Enviar email usando:"))
        }

        //Se detecta click y se envia a abrir url
        btnSendUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(Intent.createChooser(urlIntent, "Abrir usando:"))
        }
    }
}