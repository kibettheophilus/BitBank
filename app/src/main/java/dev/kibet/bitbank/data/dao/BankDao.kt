package dev.kibet.bitbank.data.dao

import androidx.room.Dao
import androidx.room.Query
import dev.kibet.bitbank.data.entity.BankEntity

@Dao
interface BankDao {
    @Query("SELECT * FROM bank")
    fun getAll(): List<BankEntity>
}