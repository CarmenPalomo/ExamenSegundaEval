package com.example.examensegundaeval

import android.os.Parcel
import android.os.Parcelable

class VideoJuego(
    private var nombre : String?,
    private var valoracion : Int
) : Parcelable {
    private var empresa : String? = " "
    private var año : Int = 0

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
        empresa = parcel.readString()
        año = parcel.readInt()
    }

    fun getNombre(): String?{
        return nombre
    }

    fun getValoracion(): Int{
        return valoracion
    }

    fun getEmpresa(): String?{
        return empresa
    }

    fun getAño(): Int{
        return año
    }

    fun setEmpresa(empresa: String){
        this.empresa = empresa
    }

    fun setAño(año: Int){
        this.año = año
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(valoracion)
        parcel.writeString(empresa)
        parcel.writeInt(año)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "VideoJuego(nombre=$nombre, valoracion=$valoracion, empresa=$empresa, año=$año)"
    }

    companion object CREATOR : Parcelable.Creator<VideoJuego> {
        override fun createFromParcel(parcel: Parcel): VideoJuego {
            return VideoJuego(parcel)
        }

        override fun newArray(size: Int): Array<VideoJuego?> {
            return arrayOfNulls(size)
        }
    }
}