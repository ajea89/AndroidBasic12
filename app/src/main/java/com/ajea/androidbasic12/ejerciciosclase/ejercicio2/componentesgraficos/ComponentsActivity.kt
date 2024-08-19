package com.ajea.androidbasic12.ejerciciosclase.ejercicio2.componentesgraficos

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val btGetInfo = findViewById<Button>(R.id.btGetInfo)
        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etName = findViewById<EditText>(R.id.etName)
        val cbTerms= findViewById<CheckBox>(R.id.cbTerms)
        val tvTerms= findViewById<TextView>(R.id.tvTerms)

        //TERMS LINK CHECKBOX
        val text = tvTerms.text
        val ss = SpannableString(text)

        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                //Aqui se pone lo que se requiere ahcer al detectar el click en el link
                Toast.makeText(this@ComponentsActivity, "Click link", Toast.LENGTH_SHORT).show()
            }

            //Se cambia el diseño default del link
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = Color.BLUE
                ds.isUnderlineText = true
            }
        }
        //Se define el comienzo y el final del link en la string
        ss.setSpan(clickableSpan, 27, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        tvTerms.text = ss
        tvTerms.movementMethod = LinkMovementMethod.getInstance()

        cbTerms.setOnCheckedChangeListener { compoundButton, isChecked ->
            Toast.makeText(this, "Terms isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //CHECKBOX
        cbCreditCard.setOnCheckedChangeListener { compoundButton, isChecked ->
            if (isChecked){
                rgSex.visibility = View.GONE
            }else{
                rgSex.visibility = View.VISIBLE
            }
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        //RADIOGROUP
        rgSex.setOnCheckedChangeListener { radioGroup, id ->
            val idName = getRgLabel(id, false)
            Toast.makeText(this,"CheckedId = $idName", Toast.LENGTH_SHORT).show()

        }

        //SPINNER
        val data = arrayListOf("No selección","México", "Colombia", "Canada", "Argentina", "Dinamarca", "Venezuela","España")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, data).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object :OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemSelected = data[position]

                if (position == 0){
                    Toast.makeText(this@ComponentsActivity, "Item no seleccion", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this@ComponentsActivity, "Item seleccionado: $itemSelected", Toast.LENGTH_LONG).show()
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                Toast.makeText(this@ComponentsActivity, "Nada seleccionado", Toast.LENGTH_LONG).show()
            }
        }

        btGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val selectedRgOption = getRgLabel(rgSex.checkedRadioButtonId, true)
            val itemSpinnerSelected = spinner.selectedItem

            if (etName.text.toString().isNotEmpty()){
                Toast.makeText(this, "isChecked = $cbStatus, checkedId = $selectedRgOption, selectedSpinnerItem = $itemSpinnerSelected, name = ${etName.text.toString()} ", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Debes ingresar tu nombre", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun getRgLabel(id:Int, isFromButon:Boolean): String{
        return when(id){
            R.id.rbWoman ->{
                if (isFromButon) "M" else "Mujer"
            }
            R.id.rbMan ->{
                if (isFromButon) "H" else "Hombre"
            }
            else -> "Desconocida"
        }
    }
}