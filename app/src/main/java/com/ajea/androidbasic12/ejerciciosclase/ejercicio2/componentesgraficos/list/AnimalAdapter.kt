package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R
import com.squareup.picasso.Picasso

class AnimalAdapter(val list: List<AnimalEntity>): RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    var onItemSelected : ((AnimalEntity) -> Unit)? = null

    //Clase de viewholder que se encarga de hacer ligado ente componente gráfico y datos y mostrar información
    class AnimalViewHolder(view:View): RecyclerView.ViewHolder(view){
        val ivAnimal = view.findViewById<ImageView>(R.id.ivAnimal)
        val tvAnimal = view.findViewById<TextView>(R.id.tvAnimal)
        val tvColor = view.findViewById<TextView>(R.id.tvColor)
        val animalCard = view.findViewById<CardView>(R.id.animalCard)

        fun render(animalEntity: AnimalEntity, onItemSelected : ((AnimalEntity) -> Unit)?) {
            tvAnimal.text = animalEntity.name
//            tvColor.text = animalEntity.color
            tvColor.typeface = ResourcesCompat.getFont(tvColor.context, R.font.bernier_shade_regular)

            animalCard.setOnClickListener {
                onItemSelected?.invoke(animalEntity)
            }

            Picasso.get()
                .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRM1-2B5wjpFuyYrSCslCd0do7Do5-wcCwnOQ&usqp=CAU")
                .placeholder(R.drawable.img_android)
                .error(R.drawable.group)
                .into(ivAnimal)

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
        holder.render(list[position], onItemSelected)
    }
}