package com.example.articlescleanarchitecture.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articulo_entity")
data class ArticuloEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "nombre")
    var nombre: String,

    @ColumnInfo(name = "codigo")
    var codigo: String,

    @ColumnInfo(name = "epc")
    var epc: String,

    @ColumnInfo(name = "codigo_int")
    var codigoInt: String,

    @ColumnInfo(name = "estado")
    var estado: String,

    @ColumnInfo(name = "precio")
    var precio: String?,

    @ColumnInfo(name = "imagen")
    var imagen: String?,

    @ColumnInfo(name = "iva")
    var iva: String?,

    @ColumnInfo(name = "articulo")
    var articulo: String,

    @ColumnInfo(name = "codigo_barra")
    var codigoBarra: String?,

    @ColumnInfo(name = "metadatadetalle1")
    var metadatadetalle1: String?,

    @ColumnInfo(name = "metadatadetalle2")
    var metadatadetalle2: String?,

    @ColumnInfo(name = "linea")
    var linea: String?
)