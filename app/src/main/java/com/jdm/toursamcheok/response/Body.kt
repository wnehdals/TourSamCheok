package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Body(
    @SerializedName("items")
    @Expose
    val items: Items = Items(),
    @SerializedName("numOfRows")
    @Expose
    val numOfRows: Int = 0,
    @SerializedName("pageNo")
    @Expose
    val pageNo: Int = 0,
    @SerializedName("totalCount")
    @Expose
    val totalCount: Int = 0
)
