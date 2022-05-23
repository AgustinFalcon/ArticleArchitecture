package com.example.articlescleanarchitecture.data.remote.parsedata

import com.google.gson.annotations.SerializedName

data class RemoteArticulo(
    var id: Int = 0,
    var codigo: String,
    var nombre: String,
    var epc: String,
    @SerializedName("codigoint")var codigoInt: String,
    var estado: String,
    var precio: String?,
    var imagen: String?,
    var iva: String?,
    var articulo: String,
    @SerializedName("cbarra")var codigoBarra: String?,
    var metadatadetalle1: String?,
    var metadatadetalle2: String?,
    var linea: String?
)