package com.example.articlescleanarchitecture.data.remote

import com.example.articlescleanarchitecture.data.local.entities.EntityMapper
import com.example.articlescleanarchitecture.data.remote.parsedata.RemoteArticulo
import com.example.articlescleanarchitecture.repository.Articulo
import javax.inject.Inject


class ArticuloNetMapper @Inject constructor(): EntityMapper<RemoteArticulo, Articulo> {

    override fun mapFromEntity(entity: RemoteArticulo): Articulo {
        return Articulo(
            id = entity.id,
            nombre = entity.nombre,
            codigo = entity.codigo,
            epc = entity.epc,
            codigoInt = entity.codigoInt,
            estado = entity.estado,
            precio = entity.precio,
            imagen = entity.imagen,
            iva = entity.iva,
            articulo = entity.articulo,
            codigoBarra = entity.codigoBarra,
            metadatadetalle1 = entity.metadatadetalle1,
            metadatadetalle2 = entity.metadatadetalle2,
            linea = entity.linea
        )
    }

    override fun mapToEntity(domainModel: Articulo): RemoteArticulo {
        return RemoteArticulo(
            id = domainModel.id,
            codigo = domainModel.codigo,
            nombre = domainModel.nombre,
            epc = domainModel.epc,
            codigoInt = domainModel.codigoInt,
            estado = domainModel.estado,
            precio = domainModel.precio,
            imagen = domainModel.imagen,
            iva = domainModel.iva,
            articulo = domainModel.articulo,
            codigoBarra = domainModel.codigoBarra,
            metadatadetalle1 = domainModel.metadatadetalle1,
            metadatadetalle2 = domainModel.metadatadetalle2,
            linea = domainModel.linea
        )
    }

    fun mapFromEntityList(entites: List<RemoteArticulo>): List<Articulo> {
        return entites.map { mapFromEntity(it) }
    }
}