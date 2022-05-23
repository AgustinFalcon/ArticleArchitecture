package com.example.articlescleanarchitecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.articlescleanarchitecture.R
import com.example.articlescleanarchitecture.databinding.FragmentInventoryCheckOutBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InventoryCheckOutFragment : Fragment() {

    private var _binding : FragmentInventoryCheckOutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInventoryCheckOutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = InventoryCheckOutFragment()
    }
}