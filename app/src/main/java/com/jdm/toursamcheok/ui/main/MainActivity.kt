package com.jdm.toursamcheok.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.StringRes
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jdm.toursamcheok.R
import com.jdm.toursamcheok.ui.theme.TourSamCheokTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TourSamCheokTheme {
                viewModel.serviceKey = getString(this.resources.getString(R.string.SERVICE_KEY))
                MainScreen()
            }
        }
    }
}

