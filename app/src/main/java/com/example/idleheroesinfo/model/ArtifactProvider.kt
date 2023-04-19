package com.example.idleheroesinfo.model

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class
ArtifactProvider(private val context: Context) {

    fun loadArtifacts(): List<Artifact> {
        val gson = Gson()

        // Read heroes.json File
        val artifactJsonFile =
            context.assets.open(
                "artifacts.json"
            ).bufferedReader().use { it.readText() }

        // Convert JSON to a list of Hero using GSON
        val listArtifactType = object : TypeToken<List<Artifact>>() {}.type
        val artifacts = gson.fromJson<List<Artifact>>(artifactJsonFile, listArtifactType)

        for (artifact in artifacts) {
            artifact.imageResourceId = context.resources.getIdentifier(
                artifact.image,
                "drawable",
                context.packageName
            )
        }

        return artifacts
    }
}