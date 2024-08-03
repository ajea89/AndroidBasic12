package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class AnimalAdapter(val list: List<AnimalEntity>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    //Clase de viewholder que se encarga de hacer ligado ente componente gráfico y datos y mostrar información
    class AnimalViewHolder(view:View): RecyclerView.ViewHolder(view){
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val tvAnimal = view.findViewById<TextView>(R.id.tvAnimal)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)

        fun render(animalEntity: AnimalEntity) {
            tvAnimal.text = animalEntity.name
            tvColor.text = animalEntity.color
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        //Se crea el view con el diseño de interfaz gráfico que tendrá cada item y se crea instancia de viewholder pasandole dicha view
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_animal, parent, false)
        return AnimalViewHolder(view)
    }

    //Método donde devolvemos el número de items a manejar
    override fun getItemCount(): Int = list.size

    //Método donde llamamos función de viewholder para mostrar informacion de elemento dentro de nuestra coleecion de datos
    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.render(list[position])
    }
}