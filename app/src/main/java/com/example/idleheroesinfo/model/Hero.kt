package com.example.idleheroesinfo.model

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
)