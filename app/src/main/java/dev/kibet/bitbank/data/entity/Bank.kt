package dev.kibet.bitbank.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank")
data class Bank(
    @PrimaryKey(autoGenerate = true) val id: Int
)