package com.jdm.toursamcheok.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jdm.toursamcheok.response.Tour


@Database(
   entities = [(Tour::class)],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tourDao(): TourDao
}