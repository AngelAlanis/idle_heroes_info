package com.example.idleheroesinfo.adapter

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.HeroListFragmentDirections
import com.example.idleheroesinfo.R
import com.example.idleheroesinfo.model.Hero

class HeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val heroPicture: ImageView = view.findViewById(R.id.hero_picture)
    private val heroName: TextView = view.findViewById(R.id.hero_name)
    private val heroShortName: TextView = view.findViewById(R.id.hero_short_name)
    private val heroFaction: TextView = view.findViewById(R.id.hero_faction)
    private val heroClass: TextView = view.findViewById(R.id.hero_class)

    private val factionIcon: ImageView = view.findViewById(R.id.faction_icon)
    private val classIcon: ImageView = view.findViewById(R.id.class_icon)

    fun render(heroModel: Hero) {
        val resources = view.context?.resources

        val imageResourceId = view.context.resources.getIdentifier(
            heroModel.image,
            "drawable",
            view.context.packageName
        )
        heroPicture.setImageResource(imageResourceId)

        classIcon.setImageResource(heroModel.getHeroClassIconId())
        factionIcon.setImageResource(R.drawable.faction_transcendence)

        heroName.text = heroModel.name
        heroShortName.text = resources?.getString(R.string.short_name, heroModel.shortName)
        heroFaction.text = resources?.getString(R.string.faction, heroModel.faction)
        heroClass.text = resources?.getString(R.string.hero_class, heroModel.heroClass)

        itemView.setOnClickListener {
            Toast.makeText(heroPicture.context, heroName.text, Toast.LENGTH_SHORT).show()
            val bundle = Bundle()
            bundle.putParcelable("hero", heroModel)

            val action =
                HeroListFragmentDirections.actionHeroListFragmentToHeroDetailFragment(hero = heroModel)
            view.findNavController().navigate(action)
        }
    }

}