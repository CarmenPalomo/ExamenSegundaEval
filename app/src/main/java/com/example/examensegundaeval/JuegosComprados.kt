package com.example.examensegundaeval

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class JuegosComprados(context: Context) : SQLiteOpenHelper(context, DATABASE, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_VERSION = 4
        private const val DATABASE = "videojuegos.db"
        private const val TABLA_VIDEOJUEGOS = "VideoJuego"
        private const val COLUMN_NOMBRE = "nombre"
        private const val COLUMN_VALORACION = "valoracion"
        private const val COLUMN_EMPRESA = "empresa"
        private const val COLUMN_AÑO = "año"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = "CREATE TABLE $TABLA_VIDEOJUEGOS ($COLUMN_NOMBRE TEXT PRIMARY KEY, " +
                "$COLUMN_VALORACION INTEGER, $COLUMN_EMPRESA TEXT, $COLUMN_AÑO INTEGER)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLA_VIDEOJUEGOS")
        onCreate(db)
    }

    fun insertarVideojuego(videojuego: VideoJuego): Long{
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NOMBRE, videojuego.getNombre())
            put(COLUMN_VALORACION, videojuego.getValoracion())
            put(COLUMN_EMPRESA, videojuego.getEmpresa())
            put(COLUMN_AÑO, videojuego.getAño())

        }
        val id = db.insert(TABLA_VIDEOJUEGOS, null, values)
        db.close()

        return id
    }


    @SuppressLint("Range")
    fun lectura(): ArrayList<VideoJuego> {
        val lectura = ArrayList<VideoJuego>()
        val selectQuery = "SELECT * FROM $TABLA_VIDEOJUEGOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NOMBRE))
                val valoracion = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_VALORACION))
                val empresa = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMPRESA))
                val año = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_AÑO))

                var videoJuego = VideoJuego(nombre, valoracion)
                videoJuego.setEmpresa(empresa)
                videoJuego.setAño(año)
                lectura.add(videoJuego)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return lectura
    }
}