package com.example.idleheroesinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ArtifactProvider(private val context: Context) {

    fun loadArtifacts(): List<ArtifactItem> {
        val gson = Gson()

        // Read heroes.json File
        val artifactJsonFile =
            context.assets.open(
                "artifacts.json"
            ).bufferedReader().use { it.readText() }

        // Convert JSON to a list of Hero using GSON
        val listHeroType = object : TypeToken<List<ArtifactItem>>() {}.type

        return gson.fromJson(artifactJsonFile, listHeroType)
    }
}