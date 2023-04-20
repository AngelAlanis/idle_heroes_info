package com.example.idleheroesinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.view.adapter.HeroCardAdapter
import com.example.idleheroesinfo.model.HeroProvider
import com.example.idleheroesinfo.databinding.FragmentHeroListBinding

class HeroListFragment : Fragment() {

    private var _binding: FragmentHeroListBinding? = null

    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHeroListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        initRecyclerView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Load the RecyclerView adapter with the Hero List in the Datasource class
        recyclerView.adapter = HeroCardAdapter(HeroProvider(requireContext()).loadHeroes())
    }

}