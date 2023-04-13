package com.example.idleheroesinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.model.Hero

// RecyclerView Adapter that shows a list of heroes.
class HeroCardAdapter(private val heroList: List<Hero>) : RecyclerView.Adapter<HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        // Inflate the hero card layout.
        val adapterLayout =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_hero, parent, false)
        return HeroViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int = heroList.size

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        // Execute for each hero card in the RecyclerView
        val hero = heroList[position]
        holder.render(hero)
    }

}