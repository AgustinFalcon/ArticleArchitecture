package com.example.articlescleanarchitecture.repository

import android.util.Log
import com.example.articlescleanarchitecture.data.local.entities.ArticuloDao
import com.example.articlescleanarchitecture.data.local.entities.ArticulodbMapper
import com.example.articlescleanarchitecture.data.remote.ArticuloNetMapper
import com.example.articlescleanarchitecture.data.remote.NetResultState
import com.example.articlescleanarchitecture.data.remote.retrofit.StockService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class ArticuloRepositoryImpl @Inject constructor(
    private val articuloDao: ArticuloDao,
    private val stockService: StockService,
    private val netMapper: ArticuloNetMapper,
    private val dbMapper: ArticulodbMapper
): ArticuloRepository {


    override suspend fun getArticulos(sucursal: String, offset: Int): Flow<NetResultState<List<Articulo>>> = flow {
        emit(NetResultState.Loading)
        try {
            //if (articuloDao.getAllArticulos().isEmpty()) {
            val networkArticulo = stockService.getArticleData(sucursal = sucursal, offset = offset)
            Log.d(TAG, "Hello. API Call with ${networkArticulo.code()} @ URL: ${networkArticulo.raw().request.url}")
            if (networkArticulo.isSuccessful) {
                val articulos = networkArticulo.body()?.let { netMapper.mapFromEntityList(it.articulos) }
                for (art in articulos!!) {
                    articuloDao.insert(dbMapper.mapToEntity(art))
                }
                val cacheArt = articuloDao.getAllArticulos()
                emit(NetResultState.Success(dbMapper.mapFromEntityList(cacheArt)))
            } else {
                //emit(NetResultState.Failure(networkArticulo.code(), networkArticulo.message()))
                Log.d(TAG, "getArticulos: Network state failure")
            }
            //} else {
            //    val cacheArt = articuloDao.getAllArticulos()
            //    emit(NetResultState.Success(dbMapper.mapFromEntityList(cacheArt)))
            // }
        } catch (e: Exception) {
            emit(NetResultState.Error(e))
        }
    }


    companion object {
        const val TAG = "ArticuloRepoImpl"
    }
}