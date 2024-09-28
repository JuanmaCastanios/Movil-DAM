package com.example.ejercicio2_spinnerlistview

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio2_spinnerlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var datos = ArrayList<String>()
        var adaptadorDatos = ArrayAdapter(this,android.R.layout.simple_list_item_1,datos)

        binding.listaDatos.adapter = adaptadorDatos

        binding.bAniadir.setOnClickListener(){
            datos.add(binding.textoDato.text.toString())
            adaptadorDatos.notifyDataSetChanged()
            binding.textoDato.text.clear()
        }

        binding.bBorrar.setOnClickListener(){
            var posicion = binding.listaDatos.checkedItemPosition
            datos.removeAt(posicion)
            adaptadorDatos.notifyDataSetChanged()
            binding.listaDatos.clearChoices()
        }


    }
}