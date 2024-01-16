package com.mohammedfares.phones.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PhoneDao {
    @Insert
    suspend fun inert(phone: Phone): Long
    @Delete
    suspend fun delete(phone: Phone): Int
    @Update
    suspend fun update(phone: Phone): Int
    @Query("SELECT * FROM mobile_phones")
    fun selectAll(): List<Phone>
    @Query("SELECT * FROM mobile_phones WHERE id = :id")
    fun selectById(id: Long): Phone
}