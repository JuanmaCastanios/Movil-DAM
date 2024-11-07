package com.example.ejem05_llamandoaotrosactivitys

import android.os.Parcel
import android.os.Parcelable

//import java.io.Serializable

//class Dato(var dato:String): Serializable {
class Dato(var dato:String?): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()) {
    }

    override fun toString(): String {
        return dato.toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dato)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dato> {
        override fun createFromParcel(parcel: Parcel): Dato {
            return Dato(parcel)
        }

        override fun newArray(size: Int): Array<Dato?> {
            return arrayOfNulls(size)
        }
    }
}