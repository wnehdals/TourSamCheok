package com.jdm.toursamcheok.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jdm.toursamcheok.repository.TourRepository
import com.jdm.toursamcheok.response.Tour
import com.jdm.toursamcheok.response.state.BaseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tourRepository: TourRepository
): ViewModel() {
    private val _selectedTab: MutableState<MainScreenHomeTab> = mutableStateOf(MainScreenHomeTab.TOUR)
    val selectedTab: State<MainScreenHomeTab> get() = _selectedTab

    private val _tourRespState: MutableState<BaseState> = mutableStateOf(BaseState.Uninitialized)
    val tourRespState: State<BaseState> get() = _tourRespState

    val tour: State<MutableList<Tour>> = mutableStateOf(mutableListOf())
    val tourPageStateFlow: MutableStateFlow<Int> = MutableStateFlow(1)
    private val newMovieFlow = tourPageStateFlow.flatMapLatest {
        _tourRespState.value = BaseState.Loading
        tourRepository.getTourList(
            page = it,
            success = {

            },
            fail = {

            }
        )
    }.shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)



    fun selectTab(tab: MainScreenHomeTab) {
        _selectedTab.value = tab
    }
}