package com.example.finance.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.finance.models.Wallet

@Dao
interface WalletDao {
    @Insert
    suspend fun insertWallet(wallet: Wallet)

    @Query("SELECT * FROM wallets")
    suspend fun getAllWallets(): List<Wallet>

    @Delete
    suspend fun deleteWallet(wallet: Wallet)
}

