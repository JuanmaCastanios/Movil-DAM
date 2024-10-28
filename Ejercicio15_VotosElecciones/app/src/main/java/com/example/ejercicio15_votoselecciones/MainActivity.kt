package com.example.ejercicio15_votoselecciones

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejercicio15_votoselecciones.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result->
            if(result.resultCode == RESULT_OK){
                binding.tvResultados.text = result.data?.getParcelableExtra("datoARetornar", Dato::class.java).toString()
            } else if (result.resultCode == RESULT_CANCELED){
                binding.tvResultados.text = "No se ha encontrado ningun dato"
            }
        }
        
        binding.botonVotos.setOnClickListener(){
            var cambiarActivityVotar:Intent = Intent(this, Activity2::class.java)
            launcher.launch(cambiarActivityVotar)

        }

    }
}