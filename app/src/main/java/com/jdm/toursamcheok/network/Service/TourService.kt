package com.jdm.toursamcheok.network.Service

import com.jdm.toursamcheok.response.TourResp
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TourService {
    @GET("/areaBasedList")
    suspend fun fetchTourData(
        @Query("ServiceKey") ServiceKey: String,
        @Query("contentTypeId") contentTypeId: Int = 12,
        @Query("areaCode") areaCode: Int = 32,
        @Query("sigunguCode") sigunguCode: Int = 4,
        @Query("listYN") listYN: String = "Y",
        @Query("MobileOS") MobileOS: String = "A",
        @Query("MobileApp") MobileApp: String = "TourSamCheok",
        @Query("arrange") arrange: String = "A",
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("_type") _type: String = "json",
    ): Response<TourResp>
}