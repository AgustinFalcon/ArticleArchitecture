package com.example.articlescleanarchitecture.repository

import com.example.articlescleanarchitecture.data.remote.NetResultState
import kotlinx.coroutines.flow.Flow

interface ArticuloRepository {
    suspend fun getArticulos(sucursal: String, offset: Int): Flow<NetResultState<List<Articulo>>>
}