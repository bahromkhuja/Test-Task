package com.example.testtask.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.testtask.presentation.AppViewModel

@Composable
fun DeatailScreen(
    appViewModel: AppViewModel = hiltViewModel()
){
    LaunchedEffect(Unit) {
        appViewModel.getData()
    }

    Column(modifier = Modifier.fillMaxSize()){

    }
}