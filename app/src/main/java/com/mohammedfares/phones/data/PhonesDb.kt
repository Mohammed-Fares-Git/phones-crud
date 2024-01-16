package com.mohammedfares.phones.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Phone::class],
    version = 1,
    exportSchema = false)
abstract class PhonesDb: RoomDatabase() {
    abstract fun phoneDao(): PhoneDao
}