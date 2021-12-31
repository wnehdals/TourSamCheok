package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TourResp(
    @SerializedName("response")
    @Expose
    val response: Response = Response()
)
