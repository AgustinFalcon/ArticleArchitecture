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
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ArticuloViewModel @Inject constructor(private val articuloRepository: ArticuloRepositoryImpl): ViewModel() {

    private val _articleViewState = MutableLiveData<ArticlesViewStates>()
    val articleViewState: LiveData<ArticlesViewStates> get() = _articleViewState


    fun getArticleState(sucursal: String, offset: Int) {
        viewModelScope.launch {
            when (val result = articuloRepository.getArticulos(sucursal, offset)) {
                is NetResultState.Success -> {
                    _articleViewState.postValue(ArticlesViewStates.Success(result.data))
                }
                is NetResultState.Error -> {
                    _articleViewState.postValue(ArticlesViewStates.Error)
                }
                else -> {
                    Log.d("viewmodel", "no entro en success = $result")
                }
            }
        }
    }
}

sealed class ArticlesViewStates {
    class Success(val listArticles: List<Articulo>): ArticlesViewStates()
    object Error: ArticlesViewStates()
}