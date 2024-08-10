package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.ejerciciosclase.ejercicios1.explicitintent.SecondActivity

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.animalList)

        //Colección de datos
        val data = listOf(AnimalEntity("Leon","Amarillo", ""),
            AnimalEntity("Tigre","Naranja", ""),
            AnimalEntity("Jirafa","Amarillo", ""),
            AnimalEntity("Armadillo","Amarillo", ""),
            AnimalEntity("Perro","Amarillo", ""),
            AnimalEntity("Gato","Amarillo", ""),
            AnimalEntity("Gato","Amarillo", ""),
            AnimalEntity("Gato","Amarillo", ""),
            AnimalEntity("Gato","Amarillo", ""),
            AnimalEntity("Gato","Amarillo", ""))

        //Se crea instancia de Adaptador pasandole la coleccion de datos
        val adapter = AnimalAdapter(data)

        adapter.onItemSelected = { animal ->
            when(animal.name){
                "Perro" ->{
                    val detailIntent = Intent(this, SecondActivity::class.java).apply {
                        putExtra("EXTRA_ANIMAL", animal)
                    }
                    startActivity(detailIntent)
                }

                else ->{
                    val detailIntent = Intent(this, AnimalDetailActivity::class.java).apply {
                        putExtra("EXTRA_ANIMAL", animal)
                    }
                    startActivity(detailIntent)
                }
            }
//            Toast.makeText(this, "name: ${animal.name}", Toast.LENGTH_LONG).show()
        }

        //Se le asigna el adaptador a la lista y se le asigna la forma de visualizar los datos con layout manager
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        list.layoutManager = GridLayoutManager(this, 3)
    }
}