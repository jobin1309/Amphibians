package com.example.amphibians.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amphibians.MainViewModel
import com.example.amphibians.adapter.AnimalAdapter
import com.example.roomdb.R
import com.example.roomdb.databinding.FragmentAmphibianLIstBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AmphibianLIstFragment : Fragment() {


    private lateinit var binding: FragmentAmphibianLIstBinding
    private val mViewmodel: MainViewModel by viewModels()
    private val mAdatper: AnimalAdapter = AnimalAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAmphibianLIstBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = mAdatper
        binding.recyclerView.layoutManager = LinearLayoutManager(context)


        mViewmodel.amphibians.observe(viewLifecycleOwner) { response ->
            mAdatper.setData(response)
        }



        return binding.root
    }


}