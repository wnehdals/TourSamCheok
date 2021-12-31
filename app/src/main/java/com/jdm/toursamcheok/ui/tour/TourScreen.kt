package com.jdm.toursamcheok.ui.tour

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.statusBarsPadding
import com.jdm.toursamcheok.ui.main.MainScreenHomeTab
import com.jdm.toursamcheok.ui.main.MainViewModel

@ExperimentalFoundationApi
@Composable
fun TourScreen(
    viewModel: MainViewModel,
    selectTour: (MainScreenHomeTab, Int) -> Unit,
    lazyListState: LazyListState,
    modifier: Modifier = Modifier
) {
    val tourRespState = viewModel.tourRespState

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        state = lazyListState,
        modifier = modifier
            .statusBarsPadding()
            .background(MaterialTheme.colors.background)
    ) {
        paging(

        )
    }
}