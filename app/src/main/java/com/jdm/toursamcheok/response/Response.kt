package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("header")
    @Expose
    val header: Header = Header(),
    @SerializedName("body")
    @Expose
    val body: Body = Body()
)
