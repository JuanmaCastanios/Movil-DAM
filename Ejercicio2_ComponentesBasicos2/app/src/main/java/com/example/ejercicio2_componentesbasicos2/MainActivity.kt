package com.example.ejercicio2_componentesbasicos2

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio2_componentesbasicos2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         */
        var datos_Desplegable = arrayOf("Valladolid", "Vigo", "Madrid", "Córdoba")
        binding.selectorCiudades.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos_Desplegable)

        binding.botonGuardar.setOnClickListener(){
            var nombre: String = binding.textoDatos.text.toString()

            var estadoCivil: String = findViewById<RadioButton>(binding.estadoCivilRG.checkedRadioButtonId).text.toString()

            var ciudad: String = binding.selectorCiudades.selectedItem.toString()

            var deportes = mutableListOf<String>()

            if(binding.checkFutbol.isChecked) deportes.add("Futbol")
            if(binding.checkBaloncesto.isChecked) deportes.add("Balonceste")
            if(binding.checkTenis.isChecked) deportes.add("Tenis")

            var persona: Persona = Persona(binding.usuario.nombre)


            var personaVacia: Persona =  Persona()
            binding.usuario = personaVacia

            Log.d("Datos Formulario", "Nombre: ${nombre}")
            Log.d("Datos Formulario", "Estado civil:  ${estadoCivil}")
            Log.d("Datos Formulario", "Ciudad: ${ciudad}")
            Log.d("Datos Formulario", "Deportes: ${deportes.joinToString(", ")}")
            if (persona != null) {
                Log.d("Datos Guardados", persona.nombre)
            }
        }


    }
}