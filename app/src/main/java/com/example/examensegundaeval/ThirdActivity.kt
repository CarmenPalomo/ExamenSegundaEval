package com.example.examensegundaeval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    private lateinit var videojuego : VideoJuego

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_activity)

        var texto : TextView = findViewById(R.id.textView)
        var botonInicio : Button = findViewById(R.id.botonInicio)
        var botonAtras: Button = findViewById(R.id.button)

        videojuego = intent.getParcelableExtra("videoJuego")!!

       texto.text = texto.text.toString() + "\n" + videojuego.toString()



        botonInicio.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        botonAtras.setOnClickListener {
            val intent = Intent(this, SecondActivityActivity::class.java)
            startActivity(intent)
        }


    }
}