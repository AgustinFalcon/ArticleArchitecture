package com.example.articlescleanarchitecture.data.remote.retrofit

import com.example.articlescleanarchitecture.data.remote.parsedata.ArticuloResponse
import com.example.articlescleanarchitecture.data.remote.parsedata.InventoryResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface StockService {

    //Paginado de todos los articulos, offset indica desde donde arranca el paginado
    @GET("ws_datos.php?operacion=52&alldata=1")
    suspend fun getArticleData(@Query("sucursal") sucursal: String, @Query("offset") offset: Int): Response<ArticuloResponse>


    //Le pasa el deposito y obtiene todos los articulos de ese deposito
    @GET("ws_datos.php?operacion=33")
    suspend fun getInventoryData(@Query("deposito") deposito: String): Response<InventoryResponse>

}