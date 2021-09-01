package dev.kibet.bitbank.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.kibet.bitbank.data.dao.BankDao
import dev.kibet.bitbank.data.entity.Bank

@Database(entities = [Bank::class], version = 1)
abstract class BankDatabase : RoomDatabase() {
    abstract fun bankDao(): BankDao

    companion object {
        @Volatile
    private var  INSTANCE: BankDatabase? = null
        fun getDatabase(context: Context): BankDatabase? {
            when(INSTANCE){
                null -> INSTANCE = Room.databaseBuilder(
                    context,BankDatabase::class.java,
                    "bank-db"
                ).build()
            }
            return INSTANCE
        }
    }
}