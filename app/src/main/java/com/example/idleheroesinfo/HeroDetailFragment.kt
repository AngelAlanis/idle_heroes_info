package com.example.idleheroesinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.idleheroesinfo.databinding.FragmentHeroDetailBinding
import com.example.idleheroesinfo.model.Hero

class HeroDetailFragment : Fragment() {
    companion object {
        const val HERO = "hero"
    }

    private var _binding: FragmentHeroDetailBinding? = null

    private val binding get() = _binding!!

    private lateinit var hero: Hero

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the Hero attribute from the previous fragment.
        arguments?.let {
            hero = it.getParcelable(HERO)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeroDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Set the Views values from the Hero
        binding.heroPower.text = "3242423"
        binding.iconClass.setImageResource(hero.getHeroClassIconId())
        binding.heroClass.text = hero.heroClass
        binding.heroBaseHp.text = hero.baseHP.toString()
        binding.heroBaseAttack.text = hero.baseAttack.toString()
        binding.heroBaseDefense.text = hero.baseDefense.toString()
        binding.heroBaseSpeed.text = hero.baseSpeed.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }


}