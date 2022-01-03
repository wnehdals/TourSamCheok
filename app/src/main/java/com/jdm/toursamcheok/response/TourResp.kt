package com.jdm.toursamcheok.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TourResp(
    @SerializedName("response")
    @Expose
    val response: Response = Response(),

    var errorMessage: String = ""
) {
    companion object{
        val ERROR = TourResp().apply {
            errorMessage = "네트워크를 확인해주세요"
        }

    }
}
