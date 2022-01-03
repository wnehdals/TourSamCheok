package com.jdm.toursamcheok.repository

import com.jdm.toursamcheok.db.TourDao
import com.jdm.toursamcheok.db.entity.TourEntity
import com.jdm.toursamcheok.network.Service.TourService
import com.jdm.toursamcheok.response.Tour
import com.jdm.toursamcheok.response.TourResp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import java.util.concurrent.Flow

class TourRepository constructor(
    private val service: TourService,
    private val tourDao: TourDao
) : Repository {

    fun getTourList(page: Int, serviceKey: String, success: () -> Unit, fail: () -> Unit) = flow<List<Tour>> {
        val tours = tourDao.getTourList(page)
        if (tours.isEmpty()) {
            val response = service.fetchTourData(
                serviceKey = serviceKey,
                pageNo = page
            )
            if (response.isSuccessful) {
                val tourResp = response.body()!!
                if (tourResp.response.header.resultMsg == "OK") {
                    val tourList = tourResp.response.body.items.item
                    for (it in tourList)
                        it.page = tourResp.response.body.pageNo
                    success()
                    emit(tourList)
                } else {
                    fail()
                }
            } else {
                fail()
            }
        } else {
            emit(tourToTourEntity(tours))
        }
    }.onCompletion { success() }.flowOn(Dispatchers.IO)
}

fun tourToTourEntity(tours: List<TourEntity>): MutableList<Tour> {
    val result = mutableListOf<Tour>()
    for (it in tours) {
        result.add(
            Tour(
                page = it.page,
                address = it.address,
                contentId = it.contentId,
                title = it.title,
                firstImage = it.firstImage
            )
        )
    }
    return result

}