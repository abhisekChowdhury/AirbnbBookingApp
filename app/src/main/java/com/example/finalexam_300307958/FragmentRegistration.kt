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
import com.example.finalexam_300307958.Entities.UserItem
import com.example.finalexam_300307958.databinding.FragmentRegistrationBinding

class FragmentRegistration : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding
    private lateinit var viewModel: FragmentMainViewModel
    private var user_id = 1000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(FragmentMainViewModel::class.java)


        binding.saveUserButton.setOnClickListener{
            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val userName = binding.usernameEditText.text.toString()
            user_id++

            val user = UserItem(firstName,lastName,userName,user_id)
            viewModel.backendfinduser(user.Username)
            viewModel.userLiveData.observe(viewLifecycleOwner, Observer {
                Log.i("NULL", "abcd")
                if (it?.Username.isNullOrEmpty()){
                    viewModel.backendAddUser(user)
                    Toast.makeText(requireContext(),userName+ "added! ID assigned: "+user_id, Toast.LENGTH_SHORT).show()
                }
                else{
                    Log.i("NOT", "abcdgggggg")
                    Toast.makeText(requireContext(),"Username already exists!", Toast.LENGTH_SHORT).show()
                }
            })


        }

        return binding.root

    }
}