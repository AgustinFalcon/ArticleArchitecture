package com.example.articlescleanarchitecture.repository

data class Articulo(
    var id: Int,
    var nombre: String,
    var codigo: String,
    var epc: String,
    var codigoInt: String,
    var estado: String,
    var precio: String?,
    var imagen: String?,
    var iva: String?,
    var articulo: String,
    var codigoBarra: String?,
    var metadatadetalle1: String?,
    var metadatadetalle2: String?,
    var linea: String?
)