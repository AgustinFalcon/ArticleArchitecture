package com.example.articlescleanarchitecture.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.articlescleanarchitecture.R
import com.example.articlescleanarchitecture.data.remote.NetResultState
import com.example.articlescleanarchitecture.databinding.FragmentInventoryProgressBinding
import com.example.articlescleanarchitecture.ui.viewmodel.ArticlesViewStates
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
        articlesViewModel.articleViewState.observe(viewLifecycleOwner, {
            when (it) {
                is ArticlesViewStates.Success -> {
                    Log.d("progressfragment", "onCreateView: ${it.listArticles}")
                    Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
                }
                ArticlesViewStates.Error -> {
                    Log.d("progressfragment", "onCreateView: $it")
                    Toast.makeText(requireContext(), "Error!", Toast.LENGTH_SHORT).show()
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