package com.example.articlescleanarchitecture.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.articlescleanarchitecture.R
import com.example.articlescleanarchitecture.databinding.FragmentHomeBinding
import com.example.articlescleanarchitecture.ui.viewmodel.ArticuloViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import java.lang.IllegalArgumentException


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val articlesViewModel: ArticuloViewModel by viewModels()

    private val TabIcons = arrayOf(
        R.drawable.ic_baseline_list_24,
        R.drawable.ic_noun_progress_24,
        R.drawable.ic_outline_done_24,
        R.drawable.ic_baseline_edit_24
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.pager.adapter = InventoryAdapter(this)
        binding.pager.currentItem = 1


        return binding.root
    }


    override fun onStart() {
        super.onStart()

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = this.resources.getStringArray(R.array.tab_array)[position]
            tab.icon = ContextCompat.getDrawable(requireContext(), TabIcons[position])
        }.attach()
    }



    class InventoryAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    InventoryFragment.newInstance()
                }
                1 -> {
                    InventoryProgressFragment.newInstance()
                }
                2 -> {
                    InventoryCheckOutFragment.newInstance()
                }
                else -> {
                    throw IllegalArgumentException("There should not be more tabs")
                }
            }
        }

    }




}