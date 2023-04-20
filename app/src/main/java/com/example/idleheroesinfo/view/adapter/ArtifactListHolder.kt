package com.example.idleheroesinfo.view.adapter

import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.databinding.ArtifactInformationBinding
import com.example.idleheroesinfo.databinding.ArtifactItemBinding
import com.example.idleheroesinfo.model.Artifact

class ArtifactListHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ArtifactItemBinding.bind(view)
    private lateinit var artifact: Artifact
    fun render(artifactModel: Artifact) {
        artifact = artifactModel
        binding.artifactImage.setImageResource(artifactModel.imageResourceId)

        itemView.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(view.context)
        val inflater = LayoutInflater.from(view.context)
        val binding = ArtifactInformationBinding.inflate(inflater)

        binding.artifactName.text =
            view.context.getString(R.string.splendid_artifact, artifact.name)
        binding.artifactDescription.text = artifact.description
        binding.artifactImage.setImageResource(artifact.imageResourceId)
        binding.artifactStats.text = artifact.getStatsToString()

        builder.setView(binding.root)
        val dialog = builder.create()
        dialog.apply {
            window?.setBackgroundDrawableResource(R.drawable.artifact_information_background)
        }
        dialog.show()
    }
}
