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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val tourRepository: TourRepository
): ViewModel() {
    lateinit var serviceKey: String
    private val _selectedTab: MutableState<MainScreenHomeTab> = mutableStateOf(MainScreenHomeTab.TOUR)
    val selectedTab: State<MainScreenHomeTab> get() = _selectedTab

    private val _tourRespState: MutableState<BaseState> = mutableStateOf(BaseState.Uninitialized)
    val tourRespState: State<BaseState> get() = _tourRespState


    val tour: State<MutableList<Tour>> = mutableStateOf(mutableListOf())
    val tourPageFlow: MutableStateFlow<Int> = MutableStateFlow(1)
    private val newMovieFlow = tourPageFlow.flatMapLatest {
        _tourRespState.value = BaseState.Loading
        tourRepository.getTourList(
            page = it,
            serviceKey = serviceKey,
            success = {
                _tourRespState.value = BaseState.Success
            },
            fail = {
                _tourRespState.value = BaseState.Fail
            }
        )
    }.shareIn(viewModelScope, SharingStarted.WhileSubscribed(), replay = 1)


    init {
        viewModelScope.launch(Dispatchers.IO) {
            newMovieFlow.collect{
                tour.value.addAll(it)
            }
        }
    }

    fun selectTab(tab: MainScreenHomeTab) {
        _selectedTab.value = tab
    }
    fun getNextTourPate() {
        if (tourRespState.value !is BaseState.Loading) {
            tourPageFlow.value++
        }
    }
}