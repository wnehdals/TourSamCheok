/*
 * Designed and developed by 2021 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jdm.toursamcheok.ui.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.jdm.toursamcheok.ui.festival.FestivalScreen
import com.jdm.toursamcheok.ui.restaurant.RestaurantScreen
import com.jdm.toursamcheok.ui.theme.Purple500
import com.jdm.toursamcheok.ui.tour.TourScreen

@Composable
fun HomeTabScreen(
  viewModel: MainViewModel,
  tabStateHolder: HomeTabStateHolder,
  selectItem: (MainScreenHomeTab, Long) -> Unit
) {
  val selectedTab by viewModel.selectedTab
  val tabs = MainScreenHomeTab.values()

  Scaffold(
    backgroundColor = MaterialTheme.colors.primarySurface,
    topBar = { MainAppBar() },
    bottomBar = {

      BottomNavigation(
        backgroundColor = Purple500,
        modifier = Modifier
          .navigationBarsHeight(56.dp)
      ) {

        tabs.forEach { tab ->
          BottomNavigationItem(
            icon = { Icon(painterResource(id = tab.drawableId), contentDescription = null) },
            label = { Text(text = stringResource(tab.title), color = Color.White) },
            selected = tab == selectedTab,
            onClick = { viewModel.selectTab(tab) },
            selectedContentColor = LocalContentColor.current,
            unselectedContentColor = LocalContentColor.current,
            modifier = Modifier.navigationBarsPadding()
          )
        }
      }
    }
  ) { innerPadding ->
    val modifier = Modifier.padding(innerPadding)

    Crossfade(selectedTab) { destination ->
      when (destination) {
        MainScreenHomeTab.TOUR -> TourScreen(
          modifier
        )
        MainScreenHomeTab.RESTAURANT -> RestaurantScreen(
          modifier
        )
        MainScreenHomeTab.FESTIVAL -> FestivalScreen(
          modifier
        )
      }
    }
  }
}
