package com.example.a21_room.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM my_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM my_table")
    fun getAll():LiveData<List<User>>
}