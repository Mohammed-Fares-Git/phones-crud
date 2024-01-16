package com.mohammedfares.phones.data

import androidx.room.Entity

@Entity(tableName = "mobile_phones")
data class Phone(
    val id: Long,
    val name: String,
    val price: Int,
    val image: String
)
