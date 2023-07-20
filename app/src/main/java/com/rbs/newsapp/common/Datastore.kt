package com.rbs.newsapp.common

import android.content.Context
import androidx.datastore.createDataStore
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import java.util.prefs.Preferences

class Datastore (context: Context) {
    private val dataStore = context.createDataStore(name = "user_prefs")
    companion object {
        val NAME_KEY = preferencesKey<String>("NAME_DATA")
    }
    suspend fun storeNewsData( name: String) {
        dataStore.edit {
            it[NAME_KEY] = name
        }
    }
    val nameFlow: Flow<String> = dataStore.data.map {
        it[NAME_KEY] ?: ""
    }
}