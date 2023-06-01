package com.example.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.amphibians.MainViewModel
import com.example.amphibians.adapter.AnimalAdapter
import com.example.roomdb.databinding.FragmentDetailsBinding

import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val args by navArgs<DetailsFragmentArgs>()
    private val mViewmodel: MainViewModel by viewModels()
    private lateinit var binding: FragmentDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = com.example.roomdb.databinding.
        FragmentDetailsBinding.inflate(inflater, container, false)


        binding.nameTxt.text = args.amphibians.name
        binding.decriptionText.text  = args.amphibians.description

        return binding.root
    }


}