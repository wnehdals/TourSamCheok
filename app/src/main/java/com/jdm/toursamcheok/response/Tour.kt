package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Tour(
    @SerializedName("addr1")
    @Expose
    val address: String = "",

    @SerializedName("contentid")
    @Expose
    val contentId: Int = 0,

    @SerializedName("title")
    @Expose
    val title: String = "",

    @SerializedName("title")
    @Expose
    val firstImage: String = "",

    )
