package com.example.testtask.presentation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testtask.presentation.screens.DeatailScreen
import com.example.testtask.presentation.screens.MainScreen
import com.example.testtask.utils.Routes

@Composable
fun Navigation(appViewModel: AppViewModel = hiltViewModel()){
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MAIN_SCREEN
    ) {
        composable(Routes.MAIN_SCREEN) {
            MainScreen(navController=navController, appViewModel=appViewModel)
        }
        composable(Routes.DETAIL_SCREEN) {
            DeatailScreen(navController=navController, appViewModel=appViewModel)
        }
    }
}