package com.example.examensegundaeval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombre: EditText = findViewById(R.id.nombre)
        var valoracion : EditText = findViewById(R.id.valoracion)
        var boton : Button = findViewById(R.id.primeroBoton)




        boton.setOnClickListener {

            if (nombre.text.toString().isNotEmpty() && valoracion.text.toString().toInt() >0){
                var videoJuego = VideoJuego(nombre.text.toString(), valoracion.text.toString().toInt())

                val intent = Intent(this, SecondActivityActivity::class.java)
                intent.putExtra("videjuego", videoJuego)
                startActivity(intent)
            }

        }
    }
}