package com.example.articlescleanarchitecture.data.local.room

import android.content.Context
import androidx.room.Room
import com.example.articlescleanarchitecture.data.local.entities.ArticuloDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): HelperDatabase {
        return Room.databaseBuilder(
            context,
            HelperDatabase::class.java,
            HelperDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideArticuloDao(helperDatabase: HelperDatabase): ArticuloDao {
        return helperDatabase.articuloDao()
    }

}