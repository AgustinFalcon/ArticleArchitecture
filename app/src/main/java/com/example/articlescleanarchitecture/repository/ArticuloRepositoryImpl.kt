package com.example.articlescleanarchitecture.repository

import android.util.Log
import com.example.articlescleanarchitecture.data.local.entities.ArticuloDao
import com.example.articlescleanarchitecture.data.local.entities.ArticulodbMapper
import com.example.articlescleanarchitecture.data.remote.ArticuloNetMapper
import com.example.articlescleanarchitecture.data.remote.NetResultState
import com.example.articlescleanarchitecture.data.remote.retrofit.StockService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ArticuloRepositoryImpl @Inject constructor(
    private val articuloDao: ArticuloDao,
    private val stockService: StockService,
    private val netMapper: ArticuloNetMapper,
    private val dbMapper: ArticulodbMapper
): ArticuloRepository {


    override suspend fun getArticulos(sucursal: String, offset: Int): NetResultState<List<Articulo>> = withContext(Dispatchers.IO) {
        try {
            //return@withContext (NetResultState.Loading)
            if (articuloDao.getAllArticulos().isEmpty()) {
            val networkArticulo = stockService.getArticleData(sucursal = sucursal, offset = offset)
            Log.d(TAG, "Hello. API Call with ${networkArticulo.code()} @ URL: ${networkArticulo.raw().request.url}")

            netMapper.mapFromEntityList(networkArticulo.body()!!.articulos).forEach {
                articuloDao.insert(dbMapper.mapToEntity(it))
            }
            val cacheArt = articuloDao.getAllArticulos()
                return@withContext (NetResultState.Success(dbMapper.mapFromEntityList(cacheArt)))

            } else {
                val cacheArt = articuloDao.getAllArticulos()
                return@withContext (NetResultState.Success(dbMapper.mapFromEntityList(cacheArt)))
            }
        } catch (e: Exception) {
            return@withContext (NetResultState.Error(e))
        }
    }

    companion object {
        const val TAG = "ArticuloRepoImpl"
    }
}