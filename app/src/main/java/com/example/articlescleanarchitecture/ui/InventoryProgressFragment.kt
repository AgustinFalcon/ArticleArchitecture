package com.example.articlescleanarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.articlescleanarchitecture.R
import com.example.articlescleanarchitecture.data.remote.NetResultState
import com.example.articlescleanarchitecture.databinding.FragmentInventoryProgressBinding
import com.example.articlescleanarchitecture.ui.viewmodel.ArticuloViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InventoryProgressFragment : Fragment() {

    private var _binding : FragmentInventoryProgressBinding? = null
    private val binding get() = _binding!!
    private val articlesViewModel: ArticuloViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInventoryProgressBinding.inflate(layoutInflater, container, false)

        articlesViewModel.getArticleState("1", 10000)
        articlesViewModel.articleState.observe(viewLifecycleOwner, {
            when (it) {
                is NetResultState.Success -> {
                    Log.d("fragment", "entro en el success = $it")
                }
            }
        })

        return binding.root
    }



    companion object {
        @JvmStatic
        fun newInstance() = InventoryProgressFragment()
    }
}