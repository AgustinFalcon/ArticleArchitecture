package com.example.articlescleanarchitecture.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.articlescleanarchitecture.data.remote.NetResultState
import com.example.articlescleanarchitecture.repository.Articulo
import com.example.articlescleanarchitecture.repository.ArticuloRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticuloViewModel @Inject constructor(private val articuloRepository: ArticuloRepositoryImpl): ViewModel() {

    private val _articleState: MutableLiveData<NetResultState<List<Articulo>>> = MutableLiveData()
    val articleState: LiveData<NetResultState<List<Articulo>>> get() = _articleState


    fun getArticleState(sucursal: String, offset: Int) {
        viewModelScope.launch {
            when (val result = articuloRepository.getArticulos(sucursal, offset)) {
                is NetResultState.Success<*> -> {
                    result.onEach {
                        _articleState.value = it
                    }
                }
                else -> {
                    Log.d("viewmodel", "no entro en success = $result")
                }
            }
        }
    }
}