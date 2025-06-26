package com.example.finance.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.finance.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    suspend fun getUser(username: String, password: String): User?
}
