package com.example.articlescleanarchitecture.data.local.entities

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface ArticuloDao {

    @Query("SELECT * FROM articulo_entity ORDER BY codigo ASC")
    fun getAllArticulos(): List<ArticuloEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(articulo: ArticuloEntity)

}