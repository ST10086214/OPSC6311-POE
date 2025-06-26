package com.example.finance.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallets")
data class Wallet(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cardHolder: String,
    val cardNumber: String,
    val expiryDate: String  // Format MM/YY
)
