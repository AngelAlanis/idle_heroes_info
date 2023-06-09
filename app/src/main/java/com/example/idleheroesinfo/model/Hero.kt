package com.example.idleheroesinfo.model

import com.example.idleheroesinfo.R

data class Hero(
    val name: String,
    val shortName: String,
    val faction: String,
    val heroClass: String,
    val basePower: Int,
    val baseHP: Int,
    val baseAttack: Int,
    val baseDefense: Int,
    val baseSpeed: Int,
    var biography: Biography,
    val image: String,
) {
    fun getHeroClassIconId(): Int {
        return when (heroClass) {
            "Warrior" -> R.drawable.class_warrior
            "Mage" -> R.drawable.class_mage
            "Ranger" -> R.drawable.class_ranger
            "Priest" -> R.drawable.class_priest
            else -> R.drawable.class_assassin
        }
    }
}

data class Biography(
    val id: String,
    val heroName: String,
    val title: String,
    val description: String
)