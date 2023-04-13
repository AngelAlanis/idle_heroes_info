package com.example.idleheroesinfo.model

import android.os.Parcel
import android.os.Parcelable
import com.example.idleheroesinfo.R

data class Hero(
    val name: String,
    val shortName: String,
    val faction: String,
    val heroClass: String,
    val baseHP: Int,
    val baseAttack: Int,
    val baseDefense: Int,
    val baseSpeed: Int,
    val image: String,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(shortName)
        parcel.writeString(faction)
        parcel.writeString(heroClass)
        parcel.writeInt(baseHP)
        parcel.writeInt(baseAttack)
        parcel.writeInt(baseDefense)
        parcel.writeInt(baseSpeed)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    fun getHeroClassIconId(): Int {
        return when (heroClass) {
            "Warrior" -> R.drawable.class_warrior
            "Mage" -> R.drawable.class_mage
            "Ranger" -> R.drawable.class_ranger
            "Priest" -> R.drawable.class_priest
            else -> R.drawable.class_assassin
        }
    }

    companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }

        override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }
    }
}