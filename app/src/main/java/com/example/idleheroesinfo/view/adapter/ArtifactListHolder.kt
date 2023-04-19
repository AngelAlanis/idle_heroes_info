package com.example.idleheroesinfo.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.databinding.ArtifactItemBinding
import com.example.idleheroesinfo.model.Artifact

class ArtifactListHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ArtifactItemBinding.bind(view)

    fun render(artifactModel: Artifact) {
        binding.artifactImage.setImageResource(artifactModel.imageResourceId)
    }
}
