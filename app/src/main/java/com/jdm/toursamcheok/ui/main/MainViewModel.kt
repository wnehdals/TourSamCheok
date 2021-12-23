package com.jdm.toursamcheok.ui.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {
    private val _selectedTab: MutableState<MainScreenHomeTab> = mutableStateOf(MainScreenHomeTab.TOUR)
    val selectedTab: State<MainScreenHomeTab> get() = _selectedTab





    fun selectTab(tab: MainScreenHomeTab) {
        _selectedTab.value = tab
    }
}