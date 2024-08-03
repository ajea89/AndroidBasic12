package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

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

        //Se le asigna el adaptador a la lista y se le asigna la forma de visualizar los datos con layout manager
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        list.layoutManager = GridLayoutManager(this, 3)
    }
}