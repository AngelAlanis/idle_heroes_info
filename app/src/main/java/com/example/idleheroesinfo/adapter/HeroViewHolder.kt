package com.example.idleheroesinfo.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.model.Hero

class HeroViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val heroPicture: ImageView = view.findViewById(R.id.hero_picture)
    val heroName: TextView = view.findViewById(R.id.hero_name)
    val heroShortName: TextView = view.findViewById(R.id.hero_short_name)
    val heroFaction: TextView = view.findViewById(R.id.hero_faction)
    val heroClass: TextView = view.findViewById(R.id.hero_class)

    fun render(heroModel: Hero) {
        val resources = view.context?.resources

        val imageResourceId = view.context.resources.getIdentifier(
            heroModel.image,
            "drawable",
            view.context.packageName
        )


        if (imageResourceId != null) {
            heroPicture.setImageResource(imageResourceId)
        }

        heroName.text = heroModel.name
        heroShortName.text = resources?.getString(R.string.short_name, heroModel.shortName)
        heroFaction.text = resources?.getString(R.string.faction, heroModel.faction)
        heroClass.text = resources?.getString(R.string.hero_class, heroModel.heroClass)
    }
}