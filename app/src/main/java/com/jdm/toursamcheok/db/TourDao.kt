package com.jdm.toursamcheok.db

import android.graphics.Movie
import androidx.room.*
import com.jdm.toursamcheok.db.entity.TourEntity

@Dao
interface TourDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTourList(tours: List<TourEntity>)

    @Update
    suspend fun updateTour(tour: TourEntity)

    @Query("SELECT * FROM TOURENTITY WHERE contentId = :contentId_")
    suspend fun getTour(contentId_: Int): TourEntity

    @Query("SELECT * FROM TOURENTITY WHERE page = :page_")
    suspend fun getTourList(page_: Int): List<TourEntity>
}