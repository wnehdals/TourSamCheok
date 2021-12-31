package com.jdm.toursamcheok.repository

import com.jdm.toursamcheok.network.Service.TourService
import com.jdm.toursamcheok.response.Tour
import kotlinx.coroutines.flow.flow
import java.util.concurrent.Flow

class TourRepository constructor(private val service: TourService): Repository {

    fun getTourList(page: Int, success: () -> Unit, fail: () -> Unit) = flow {

    }
}