package com.mohammedfares.phones.domain

import com.mohammedfares.phones.data.Phone

interface IRepository {
    fun getAll(): List<Phone>
    fun getById(id: Long): Phone?
    suspend fun delete(phone: Phone): Int
    suspend fun update(phone: Phone): Int
    suspend fun create(phone: Phone): Long
    suspend fun search(searchParam: String): List<String>
}