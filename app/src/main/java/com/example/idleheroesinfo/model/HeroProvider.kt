package com.example.idleheroesinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HeroProvider(private val context: Context) {
    fun loadHeroes(): List<Hero> {
        val heroes: MutableList<Hero> = mutableListOf()
        val gson = Gson()

        // Read heroes.json File
        val heroJsonFile =
            context.assets.open(
                "heroes.json"
            ).bufferedReader().use { it.readText() }

        // Convert JSON to a list of Hero using GSON
        val listHeroType = object : TypeToken<List<Hero>>() {}.type
        val heroList: List<Hero> = gson.fromJson(heroJsonFile, listHeroType)

        // Read bios.json
        val biographyJsonFile =
            context.assets.open(
                "bios.json"
            ).bufferedReader().use { it.readText() }

        // Convert JSON file to a list of biographies
        val listBiographyType = object : TypeToken<List<Biography>>() {}.type
        val biographyList: List<Biography> = gson.fromJson(biographyJsonFile, listBiographyType)

        // Add the BiographyItem to the corresponding hero
        for (hero in heroList) {
            // Match Hero.name with BiographyItem.heroName
            val biography = biographyList.find { it.heroName == hero.name }
            if (biography != null) {
                hero.biography = biography
            }
            heroes.add(hero)
        }
        return heroes
    }
}