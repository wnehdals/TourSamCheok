package com.jdm.toursamcheok.db.entity

import androidx.room.Entity
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.concurrent.Immutable

@Immutable
@Entity(primaryKeys = [("id")])
data class TourEntity(
    var page: Int,
    val address: String,
    val contentId: Int,
    val title: String,
    val firstImage: String
)
