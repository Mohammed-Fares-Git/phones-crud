package com.mohammedfares.phones.data

import com.mohammedfares.phones.domain.IRepository
import javax.inject.Inject

class Repository @Inject constructor(
    val dao: PhoneDao
): IRepository {
    override fun getAll(): List<Phone> {
        return dao.selectAll()
    }
    override fun getById(id: Long): Phone? {
        return dao.selectById(id)
    }
    override suspend fun delete(phone: Phone): Int {
        return dao.delete(phone)
    }
    override suspend fun update(phone: Phone): Int {
        return dao.update(phone)
    }
    override suspend fun create(phone: Phone): Long {
        return dao.inert(phone)
    }

    override suspend fun search(searchParam: String): List<String> {
        return dao.searchPhoneNames(searchParam)
    }

}