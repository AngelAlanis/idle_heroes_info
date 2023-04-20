package com.example.idleheroesinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.idleheroesinfo.model.HeroProvider
import com.example.idleheroesinfo.databinding.FragmentHeroDetailBinding
import com.example.idleheroesinfo.model.Hero
import java.text.NumberFormat

class HeroDetailFragment : Fragment() {
    companion object {
        const val HERO_POSITION = "heroPosition"
    }

    private var _binding: FragmentHeroDetailBinding? = null

    private val binding get() = _binding!!

    private lateinit var hero: Hero

    private var heroPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the Hero attribute from the previous fragment.
        arguments?.let {
            heroPosition = it.getInt(HERO_POSITION)
        }

        hero = HeroProvider(requireContext()).loadHeroes()[heroPosition]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Set the Views values from the Hero
        binding.heroName.text = hero.name
        binding.heroShortName.text = hero.shortName

        binding.heroPower.text = formatNumber(hero.basePower)

        binding.iconClass.setImageResource(hero.getHeroClassIconId())
        binding.heroClass.text = hero.heroClass

        binding.heroBaseHp.text = formatNumber(hero.baseHP)
        binding.heroBaseAttack.text = formatNumber(hero.baseAttack)
        binding.heroBaseDefense.text = formatNumber(hero.baseDefense)
        binding.heroBaseSpeed.text = formatNumber(hero.baseSpeed)

        binding.biographyLabel.text = hero.biography.title
        binding.heroBiography.text = hero.biography.description
    }

    private fun formatNumber(number: Int): String {
        return NumberFormat.getNumberInstance().format(number).toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}