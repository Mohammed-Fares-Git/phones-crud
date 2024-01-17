package com.mohammedfares.phones.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile_phones")
data class Phone(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String,
    val price: Int,
    val image: String,
    val rank: Int = 1
)
