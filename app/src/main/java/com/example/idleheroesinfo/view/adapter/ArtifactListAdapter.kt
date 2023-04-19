package com.example.idleheroesinfo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.model.Artifact

class ArtifactListAdapter(
    private val artifactlist: List<Artifact>
) : RecyclerView.Adapter<ArtifactListHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtifactListHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.artifact_item, parent, false)
        return ArtifactListHolder(adapterLayout)
    }

    override fun getItemCount(): Int = artifactlist.size

    override fun onBindViewHolder(holder: ArtifactListHolder, position: Int) {
        val artifact = artifactlist[position]
        holder.render(artifact)
    }


}

