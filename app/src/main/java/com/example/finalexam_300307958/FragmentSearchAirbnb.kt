package com.example.finalexam_300307958

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bikeapplication.Adapters.Adapter
import com.example.finalexam_300307958.Entities.Bathrooms
import com.example.finalexam_300307958.databinding.FragmentSearchAirbnbBinding

class FragmentSearchAirbnb : Fragment(), Adapter.ListItemListener {

    private lateinit var binding: FragmentSearchAirbnbBinding
    private lateinit var viewModel: FragmentMainViewModel
    private lateinit var adapter: Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewModel = ViewModelProvider(this).get(FragmentMainViewModel::class.java)
        binding = FragmentSearchAirbnbBinding.inflate(inflater,container,false)

        with (binding.recyclerView) {
            setHasFixedSize(true) // all rows would have a fix size regardless of its contents

            // to create a divider to separate each row
            val divider = DividerItemDecoration(context, LinearLayoutManager(context).orientation)
            addItemDecoration(divider)
        }

        binding.btnSearchQuery.setOnClickListener {
            val accommodates = binding.etNoOfPeople.text.toString().toInt()
            val bedrooms = binding.etNoOfBedroom.text.toString().toInt()
            val beds = binding.etNoOfBed.text.toString().toInt()
            val minimumNights = binding.etMinNights.text.toString()
            val maximumNights = binding.etMaxNights.text.toString()
            val bathrooms = binding.etNoOfBathrooms.text.toString()
            //val bath = Bathrooms(bathrooms)

            //val search = ListingItem(accommodates, bedrooms, beds, minimumNights, maximumNights)

            viewModel.backendSearchListingsList(accommodates,bedrooms,beds,minimumNights,maximumNights,bathrooms)
            viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
                Log.i("NULL", "abcd")
                if (it!=null){
                    adapter = Adapter(it,this@FragmentSearchAirbnb)
                    binding.recyclerView.adapter = adapter
                    binding.recyclerView.layoutManager = LinearLayoutManager(activity)
                }
                else{
                    Log.i("NOT", "abcdgggggg")
                    Toast.makeText(requireContext(),
                        "We do not have a place with $bedrooms bedrooms and could accommodate $accommodates people", Toast.LENGTH_SHORT).show()
                }
            })


        }

        binding.btnCancelSearch.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentSearchAirbnb_to_fragmentMain)
        }


//        viewModel.backendListingsList()
//        viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
//            if(it!=null){
//                adapter = Adapter(it,this@FragmentSearchAirbnb)
//                binding.recyclerView.adapter = adapter
//                binding.recyclerView.layoutManager = LinearLayoutManager(activity)
//            }else {
//                Log.i("error","no data found")
//            }
//        })


        return binding.root
    }
}