package com.example.examensegundaeval

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivityActivity : AppCompatActivity() {

    private lateinit var videojuego: VideoJuego
    private lateinit var baseDatos: JuegosComprados


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        var empresa: EditText = findViewById(R.id.empresa)
        var año: EditText = findViewById(R.id.año)
        var botonSiguiente: Button = findViewById(R.id.segundoBoton)
        var botonAtras: Button = findViewById(R.id.botonArtras)
        var botonGuardar: Button = findViewById(R.id.botonguardar)
        baseDatos = JuegosComprados(applicationContext)

        videojuego = intent.getParcelableExtra("videjuego")!!



        botonGuardar.setOnClickListener {
            if (empresa.text.toString().isNotEmpty() && año.text.toString().toInt() > 0) {

                videojuego.setEmpresa(empresa.text.toString())
                videojuego.setAño(año.text.toString().toInt())


            }

            baseDatos.insertarVideojuego(videojuego)
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)


        }

        botonSiguiente.setOnClickListener {

            if (empresa.text.toString().isNotEmpty() && año.text.toString().toInt() > 0) {

                videojuego.setEmpresa(empresa.text.toString())
                videojuego.setAño(año.text.toString().toInt())

                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("videoJuego", videojuego)
                startActivity(intent)
            }

        }

        botonAtras.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}