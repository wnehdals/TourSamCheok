package com.jdm.toursamcheok.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.jdm.toursamcheok.R
import com.jdm.toursamcheok.ui.navigation.NavScreen
import com.jdm.toursamcheok.ui.theme.Purple500

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val tabStateHolder = HomeTabStateHolder(
        rememberLazyListState(),
        rememberLazyListState(),
        rememberLazyListState()
    )
    ProvideWindowInsets {
        NavHost(navController = navController, startDestination = NavScreen.Tour.route ) {
            composable(
                route = NavScreen.Tour.route,
                arguments = emptyList()
            ) {
                HomeTabScreen(
                    viewModel = hiltViewModel(),
                    tabStateHolder = tabStateHolder,
                    selectItem = {tab, index ->
                        when (tab) {
                            MainScreenHomeTab.TOUR -> navController.navigate("${NavScreen.TourDetails.route}/$index")
                            MainScreenHomeTab.RESTAURANT -> navController.navigate("${NavScreen.RestaurantDetails.route}/$index")
                            MainScreenHomeTab.TOUR -> navController.navigate("${NavScreen.FestivalDetails.route}/$index")
                        }
                    }
                )
            }

        }
    }

}

@Composable
fun MainAppBar() {
    TopAppBar(
        backgroundColor = Purple500,
        modifier = Modifier.height(48.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically),
            text = stringResource(id = R.string.app_name),
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Immutable
enum class MainScreenHomeTab(
    @StringRes val title: Int,
    @DrawableRes val drawableId: Int
) {
    TOUR(R.string.bottom_tour, R.drawable.ic_baseline_tour_24),
    RESTAURANT(R.string.bottom_restaurant, R.drawable.ic_baseline_restaurant_24),
    FESTIVAL(R.string.bottom_festival, R.drawable.ic_baseline_festival_24)
}