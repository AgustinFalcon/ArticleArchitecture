package com.example.articlescleanarchitecture

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class App : Application() {

    val appScope = CoroutineScope(SupervisorJob())

    private val db = {
        //HelperDatabase.getDatabase(this)
    }

}