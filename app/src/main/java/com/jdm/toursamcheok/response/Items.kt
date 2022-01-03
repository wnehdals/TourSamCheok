package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("item")
    @Expose
    val item: MutableList<Tour> = mutableListOf()
)
