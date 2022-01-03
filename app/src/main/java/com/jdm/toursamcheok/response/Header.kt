package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Header(
    @SerializedName("resultCode")
    @Expose
    val resultCode: String = "",

    @SerializedName("resultMsg")
    @Expose
    val resultMsg: String = "unkown"
)
