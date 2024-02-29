package com.example.examensegundaeval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SaveActivity : AppCompatActivity() {

    private lateinit var baseDatos : JuegosComprados
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.save_activity)

        var texto : TextView = findViewById(R.id.textView2)
        var botonInicio : Button = findViewById(R.id.botonInicio2)
        var botonAtras : Button = findViewById(R.id.button2)
        baseDatos = JuegosComprados(applicationContext)

        var lista = baseDatos.lectura()

        for (i in lista){
            texto.text = texto.text.toString() + "\n" +
                    "Nombre = ${i.getNombre()}," +
                    "Valoracion = ${i.getValoracion()}, " +
                    "Empresa = ${i.getEmpresa()}," +
                    "Año = ${i.getAño()}" + "\n"
        }


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