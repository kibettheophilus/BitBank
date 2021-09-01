package dev.kibet.bitbank.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "bank_datastore")

class UserPreference(val context: Context) {
    private val appContext = context.applicationContext

    //function to save bank account
    suspend fun saveBankAccount(accountNumber: String){
        appContext.datastore.edit { preferences ->
            preferences[BANK_ACCOUNT] = accountNumber
        }
    }

    //function to retreive bank account
    val savedBankAccount: Flow<String?>
    = appContext.datastore.data.map { preferences ->
        preferences[BANK_ACCOUNT]
    }


    companion object{
        private val BANK_ACCOUNT = stringPreferencesKey("bank_account")
    }
}