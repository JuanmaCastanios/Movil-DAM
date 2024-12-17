package com.example.ejercicio18_sharedpreferencesqlitefragments

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import com.example.ejercicio18_sharedpreferencesqlitefragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val basedatos: BD =
            Room.databaseBuilder(this, BD::class.java, "bdUsuarios").allowMainThreadQueries().build()
        val usuarioDAO = basedatos.usuarioDao()

        val sharedPrefLectura = getSharedPreferences("preferencias", MODE_PRIVATE)
        var nombre : String? =  sharedPrefLectura.getString("ultimoNombre", "No definido")
        var telefono : String? =  sharedPrefLectura.getString("ultimoTelefono", "No definido")
        binding.usuario = Usuario(nombre!! , telefono!!)

        binding.bGuardar.setOnClickListener(){
            var nuevoUsuario : Usuario = Usuario(binding.tietNombre.text.toString(),binding.tietTelefono.text.toString())
            usuarioDAO?.insertar(nuevoUsuario)
            val sharedPreference = getSharedPreferences("preferencias", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("UltimoNombre", nuevoUsuario.nombre)
            editor.putString("UltimoTelefono", nuevoUsuario.telefono)
            editor.commit()
            binding.tietNombre.text?.clear()
            binding.tietTelefono.text?.clear()

        }

        binding.bFinalizar.setOnClickListener(){
            System.exit(0)
        }
    }
}