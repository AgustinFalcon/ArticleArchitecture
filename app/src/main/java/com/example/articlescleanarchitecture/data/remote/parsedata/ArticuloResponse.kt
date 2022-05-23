package com.example.articlescleanarchitecture.data.remote.parsedata

data class ArticuloResponse(
    var actualizaciones: Int,
    var articulos: List<RemoteArticulo>,
    var limit: Int,
    var total: String
)