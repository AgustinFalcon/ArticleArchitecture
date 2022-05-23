package com.example.articlescleanarchitecture.data.local.entities

import com.example.articlescleanarchitecture.repository.Articulo
import javax.inject.Inject

class ArticulodbMapper @Inject constructor(): EntityMapper<ArticuloEntity, Articulo>{

    override fun mapFromEntity(entity: ArticuloEntity): Articulo {
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

    override fun mapToEntity(domainModel: Articulo): ArticuloEntity {
        return ArticuloEntity(
            id = domainModel.id,
            nombre = domainModel.nombre,
            codigo = domainModel.codigo,
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

    fun mapFromEntityList(entities: List<ArticuloEntity>): List<Articulo> {
        return entities.map { mapFromEntity(it) }
    }
}