package com.example.ejercicio5_ontouchlistener

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio5_ontouchlistener.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var usuarios : Array<Persona> = arrayOf(Persona("Juan", "1111"), Persona("José", "2222"), Persona("Pepe", "3333"))
        var adaptador = ArrayAdapter(this, android.R.layout.simple_list_item_1,usuarios)
        var movimientoRegistrado: Boolean = false

        binding.listaUsuarios.adapter = adaptador

        binding.listaUsuarios.setOnItemClickListener { adapterView, view, i, l ->
            for ( i in usuarios){
                if(i.nombre == binding.listaUsuarios.selectedItem.toString())
                    binding.usuario.nombre = i.nombre
                    binding.usuario.contrasena = i.contrasena
            }
        }

        binding.recuadroAzul.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    if (!movimientoRegistrado) {
                        movimientoRegistrado = true

                    }
                }
                MotionEvent.ACTION_UP -> {
                    movimientoRegistrado = false
                }
            }
            false
        }

    }
}