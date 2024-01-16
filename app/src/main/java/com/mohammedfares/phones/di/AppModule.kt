package com.mohammedfares.phones.di

import android.content.Context
import androidx.room.Room
import com.mohammedfares.phones.data.PhoneDao
import com.mohammedfares.phones.data.PhonesDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRoomDb(@ApplicationContext ctx: Context): PhonesDb{
        return Room.databaseBuilder(
            ctx,
            PhonesDb::class.java,
            "phones_db"
        ).build()
    }

    @Provides
    @Singleton
    fun providesPhoneDAo(phonesDb: PhonesDb): PhoneDao{
        return phonesDb.phoneDao();
    }
}