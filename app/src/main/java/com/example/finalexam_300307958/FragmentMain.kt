package com.example.finalexam_300307958

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.finalexam_300307958.databinding.FragmentMainFragmentBinding

class FragmentMain : Fragment() {

    private lateinit var viewModel: FragmentMainViewModel
    private lateinit var binding: FragmentMainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(FragmentMainViewModel::class.java)
        binding = FragmentMainFragmentBinding.inflate(inflater,container,false)

        binding.btnSearch.setOnClickListener {
            val action = FragmentMainDirections.actionFragmentMainToFragmentSearchAirbnb()
            findNavController().navigate(action)
        }

        binding.btnRegistration.setOnClickListener {
            val action = FragmentMainDirections.actionFragmentMainToFragmentRegistration()
            findNavController().navigate(action)
        }

        return binding.root
    }
}