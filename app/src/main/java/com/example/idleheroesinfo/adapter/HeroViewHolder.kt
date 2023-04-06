package com.example.idleheroesinfo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.model.Hero

class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val heroPicture: ImageView = view.findViewById(R.id.hero_picture)
    val heroName: TextView = view.findViewById(R.id.hero_name)
    val heroShortName: TextView = view.findViewById(R.id.hero_short_name)
    val heroFaction: TextView = view.findViewById(R.id.hero_faction)
    val heroClass: TextView = view.findViewById(R.id.hero_class)

    fun render(heroModel: Hero) {
        heroName.text = heroModel.name
        heroShortName.text = heroModel.shortName
        heroFaction.text = heroModel.faction
        heroClass.text = heroModel.heroClass
    }
}