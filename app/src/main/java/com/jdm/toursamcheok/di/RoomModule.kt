package com.jdm.toursamcheok.di

import android.content.Context
import androidx.room.Room
import com.jdm.toursamcheok.db.AppDatabase
import com.jdm.toursamcheok.db.TourDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoomDataBase(@ApplicationContext context: Context): AppDatabase {
        return Room
            .databaseBuilder(context, AppDatabase::class.java, "TourSamcheok.db")
            .allowMainThreadQueries()
            .build()
    }
    @Provides
    @Singleton
    fun provideTourDao(appDatabase: AppDatabase): TourDao {
        return appDatabase.tourDao()
    }
}