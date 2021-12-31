package com.jdm.toursamcheok.di

import com.jdm.toursamcheok.network.Service.TourService
import com.jdm.toursamcheok.repository.TourRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideTourRepository(
        tourService: TourService
    ): TourRepository {
        return TourRepository(tourService)
    }
}