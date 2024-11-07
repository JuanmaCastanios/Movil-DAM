package com.example.ejem05_llamandoaotrosactivitys

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejem05_llamandootrosactivitys.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var launcher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
                result ->
            if (result.resultCode==RESULT_OK){
                binding.tvDatoActivity2.text=result.data?.getStringExtra("datoARetornar")
            }else if (result.resultCode==RESULT_CANCELED){
                binding.tvDatoActivity2.text="No viene información"
            }
        }

        binding.bIrActivity2.setOnClickListener {
            var miIntent: Intent= Intent(this, Activity2::class.java)
            miIntent.putExtra("dato", binding.tietDato.text.toString())
            //startActivity(miIntent)
            launcher.launch(miIntent)
        }


    }
}