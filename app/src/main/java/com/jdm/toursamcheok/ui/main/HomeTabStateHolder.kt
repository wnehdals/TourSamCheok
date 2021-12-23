package com.jdm.toursamcheok.ui.main

import androidx.compose.foundation.lazy.LazyListState

data class HomeTabStateHolder(
    val tourLazyListState: LazyListState,
    val restaurantLazyListState: LazyListState,
    val festivalLazyListState: LazyListState
)
