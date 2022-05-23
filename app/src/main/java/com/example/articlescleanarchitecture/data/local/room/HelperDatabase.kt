package com.example.articlescleanarchitecture.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.articlescleanarchitecture.data.local.entities.ArticuloDao
import com.example.articlescleanarchitecture.data.local.entities.ArticuloEntity

@Database(entities = [ArticuloEntity::class], version = 1, exportSchema = false)
abstract class HelperDatabase : RoomDatabase() {

    abstract fun articuloDao() : ArticuloDao

    companion object {
        const val DATABASE_NAME: String = "stockinteligente_db"
    }
}