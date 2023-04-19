package com.example.idleheroesinfo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idleheroesinfo.databinding.FragmentArtifactListBinding
import com.example.idleheroesinfo.model.ArtifactProvider
import com.example.idleheroesinfo.view.adapter.ArtifactListAdapter

class ArtifactListFragment : Fragment() {

    private var _binding: FragmentArtifactListBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentArtifactListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerView = binding.recyclerView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = GridLayoutManager(context, 3)
        // Load the RecyclerView adapter with the artifact List in the Datasource class
        recyclerView.adapter = ArtifactListAdapter(
            ArtifactProvider(requireContext()).loadArtifacts()
        )

    }
}