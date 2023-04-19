package com.example.idleheroesinfo.model

data class Artifact(
    val name: String,
    val description: String,
    val image: String,
    val stats: Stats,
    var imageResourceId: Int = 0
)

data class Stats(
    val stat1: String,
    val stat2: String,
    val stat3: String,
)