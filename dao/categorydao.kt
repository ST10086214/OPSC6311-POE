package com.example.finance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finance.models.Category

@Dao
interface CategoryDao {
    @Insert
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM categories")
    suspend fun getAllCategories(): List<Category>
}
