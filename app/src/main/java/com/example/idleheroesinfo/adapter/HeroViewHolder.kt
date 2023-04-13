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
import com.example.idleheroesinfo.databinding.ListHeroBinding
import com.example.idleheroesinfo.model.Hero

class HeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ListHeroBinding.bind(view)

    fun render(heroModel: Hero) {
        // Initialize resources to avoid writing view.context?.resources every time
        val resources = view.context?.resources

        // Get the hero picture based on the name in the Hero.image
        val imageResourceId = view.context.resources.getIdentifier(
            heroModel.image,
            "drawable",
            view.context.packageName
        )

        // Set the imageResources for the card
        binding.heroPicture.setImageResource(imageResourceId)
        binding.classIcon.setImageResource(heroModel.getHeroClassIconId())
        binding.factionIcon.setImageResource(R.drawable.faction_transcendence)

        // Set the other attributes of the hero
        binding.heroName.text = heroModel.name
        binding.heroShortName.text = resources?.getString(R.string.short_name, heroModel.shortName)
        binding.heroFaction.text = resources?.getString(R.string.faction, heroModel.faction)
        binding.heroClass.text = resources?.getString(R.string.hero_class, heroModel.heroClass)

        itemView.setOnClickListener {
            // Create a bundle and put the Hero
            val bundle = Bundle()
            bundle.putParcelable("hero", heroModel)

            // Send the Hero parcelable bundle to the HeroDetailFragment and go to that fragment
            val action =
                HeroListFragmentDirections.actionHeroListFragmentToHeroDetailFragment(hero = heroModel)
            view.findNavController().navigate(action)
        }
    }

}