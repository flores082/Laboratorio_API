package com.example.flores.laboratorio_api.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.flores.laboratorio_api.entity.User
import com.example.flores.laboratorio_api.entity.UserWithProducts


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Transaction
    @Query("SELECT * FROM user")
    fun getUsersWithPlaylists(): List<UserWithProducts>

    @Delete
    fun delete(user: User)
}