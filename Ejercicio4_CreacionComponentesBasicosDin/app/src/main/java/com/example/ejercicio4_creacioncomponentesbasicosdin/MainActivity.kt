package com.example.ejercicio4_creacioncomponentesbasicosdin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio4_creacioncomponentesbasicosdin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var contrasena: Int = 0

        var listener: View.OnClickListener = View.OnClickListener { boton ->
            contrasena += (boton as Button).text.toString().toInt()
            binding.textoContraseA.text = contrasena.toString()
        }

        fun onClick(boton: View?){

        }

    }
}