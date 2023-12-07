package com.example.flores.laboratorio_api.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.flores.laboratorio_api.entity.Product
import java.util.List

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): List<Product>

    @Query("SELECT * FROM product WHERE user_id = :userid ")
    fun findByUser(userid: Int): List<Product>

    @Insert
    fun insertAll(vararg products: Product)
}
