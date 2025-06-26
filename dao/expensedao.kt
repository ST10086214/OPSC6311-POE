package com.example.finance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finance.models.Expense

@Dao
interface ExpenseDao {
    @Insert
    suspend fun insertExpense(expense: Expense)

    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getExpensesBetween(startDate: String, endDate: String): List<Expense>

    @Query("SELECT SUM(amount) FROM expenses WHERE categoryId = :categoryId AND date BETWEEN :startDate AND :endDate")
    suspend fun getTotalAmountByCategory(categoryId: Int, startDate: String, endDate: String): Double?
}
