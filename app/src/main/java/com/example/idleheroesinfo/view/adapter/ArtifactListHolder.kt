package com.example.idleheroesinfo.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.databinding.ArtifactItemBinding
import com.example.idleheroesinfo.model.ArtifactItem

class ArtifactListHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ArtifactItemBinding.bind(view)

    fun render(artifactModel: ArtifactItem) {
        binding.artifactImage.setImageResource(R.drawable.ic_attack)
    }
}
