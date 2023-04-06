package com.example.idleheroesinfo.data

import android.content.Context
import com.example.idleheroesinfo.model.Hero
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Datasource(private val context: Context) {
    fun loadHeroes(): List<Hero> {
        val heroes: MutableList<Hero> = mutableListOf()

        // Read JSON File
        val jsonFileString =
            context.assets.open("heroes.json").bufferedReader().use { it.readText() }

        // Convert JSON to a list of Hero using GSON
        val gson = Gson()
        val listHeroType = object : TypeToken<List<Hero>>() {}.type
        val heroList: List<Hero> = gson.fromJson(jsonFileString, listHeroType)

        heroes.addAll(heroList)

        return heroes
    }
}