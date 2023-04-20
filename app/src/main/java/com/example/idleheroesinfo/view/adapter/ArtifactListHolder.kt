package com.example.idleheroesinfo.view.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.databinding.ArtifactInformationBinding
import com.example.idleheroesinfo.databinding.ArtifactItemBinding
import com.example.idleheroesinfo.model.Artifact

class ArtifactListHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ArtifactItemBinding.bind(view)

    fun render(artifactModel: Artifact) {
        binding.artifactImage.setImageResource(artifactModel.imageResourceId)

        itemView.setOnClickListener {
            val builder = AlertDialog.Builder(view.context)
            val inflater = LayoutInflater.from(view.context)
            val binding = ArtifactInformationBinding.inflate(inflater)

            binding.artifactName.text = view.context.getString(R.string.splendid_artifact, artifactModel.name)
            binding.artifactDescription.text = artifactModel.description
            binding.artifactImage.setImageResource(artifactModel.imageResourceId)
            binding.artifactStats.text = artifactModel.getStatsToString()

            builder.setView(binding.root)
            builder.create()
            builder.show()

        }
    }
}
