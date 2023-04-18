package com.example.idleheroesinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Datasource(private val context: Context) {
    fun loadHeroes(): List<Hero> {
        val heroes: MutableList<Hero> = mutableListOf()
        val gson = Gson()

        // Read JSON File
        val heroJsonFile =
            context.assets.open("heroes.json").bufferedReader().use { it.readText() }

        // Convert JSON to a list of Hero using GSON
        val listHeroType = object : TypeToken<List<Hero>>() {}.type
        val heroList: List<Hero> = gson.fromJson(heroJsonFile, listHeroType)

        val biographyJsonFile =
            context.assets.open("bios.json").bufferedReader().use { it.readText() }
        val listBiographyType = object : TypeToken<List<BiographyItem>>() {}.type
        val biographyList: List<BiographyItem> = gson.fromJson(biographyJsonFile, listBiographyType)

        for (hero in heroList) {
            val biography = biographyList.find { it.heroName == hero.name }
            if (biography != null) {
                hero.biography = biography
            }
            heroes.add(hero)
        }
        return heroes
    }
}