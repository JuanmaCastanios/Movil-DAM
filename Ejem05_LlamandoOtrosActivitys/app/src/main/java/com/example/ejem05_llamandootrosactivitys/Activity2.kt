package com.example.ejem05_llamandoaotrosactivitys

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ejem05_llamandootrosactivitys.databinding.Activity2Binding

class Activity2 : AppCompatActivity() {

    lateinit var binding: Activity2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvDatoPasado.text=this.intent.getStringExtra("dato").toString()

        binding.bVolverActivity1.setOnClickListener {
            /* binding.tietDatoARetornar.text.toString().let { texto->
                 setResult(RESULT_OK, intent.putExtra("datoARetornar", texto))
             }*/
            var datoARetornar:String=binding.tietDatoARetornar.text.toString()
            setResult(RESULT_OK, intent.putExtra("datoARetornar", datoARetornar))
            finish()
        }


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }
}