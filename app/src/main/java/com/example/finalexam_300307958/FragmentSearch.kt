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
import androidx.navigation.fragment.findNavController
import com.example.finalexam_300307958.Entities.Bathrooms
import com.example.finalexam_300307958.Entities.ListingItem
import com.example.finalexam_300307958.databinding.FragmentSearchBinding

class FragmentSearch : Fragment(){
    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: FragmentMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSearchBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FragmentMainViewModel::class.java)


        binding.btnSearchQuery.setOnClickListener {
            val accommodates = binding.etNoOfPeople.text.toString().toInt()
            val bedrooms = binding.etNoOfBedroom.text.toString().toInt()
            val beds = binding.etNoOfBed.text.toString().toInt()
            val minimumNights = binding.etMinNights.text.toString()
            val maximumNights = binding.etMaxNights.text.toString()
            val bath = Bathrooms("1.0")

            //val search = ListingItem(accommodates, bedrooms, beds, minimumNights, maximumNights)

            viewModel.backendSearchListingsList(accommodates,bedrooms,beds,minimumNights,maximumNights,bathrooms = "")
            viewModel.liveDataList.observe(viewLifecycleOwner, Observer {
                Log.i("NULL", "abcd")
                if (it!=null){

                }
                else{
                    Log.i("NOT", "abcdgggggg")
                    Toast.makeText(requireContext(),"Username already exists!", Toast.LENGTH_SHORT).show()
                }
            })

            //findNavController().navigate(R.id.action_registrationFragment_to_loginFragment)
        }



        return binding.root
    }

}