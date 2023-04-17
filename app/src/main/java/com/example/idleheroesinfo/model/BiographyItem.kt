package com.example.idleheroesinfo.model

import android.os.Parcel
import android.os.Parcelable

data class BiographyItem(
    val id: String,
    val heroName: String,
    val title: String,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(description)
        parcel.writeString(heroName)
        parcel.writeString(id)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BiographyItem> {
        override fun createFromParcel(parcel: Parcel): BiographyItem {
            return BiographyItem(parcel)
        }

        override fun newArray(size: Int): Array<BiographyItem?> {
            return arrayOfNulls(size)
        }
    }
}