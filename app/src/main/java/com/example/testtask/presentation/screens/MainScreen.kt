package com.example.testtask.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.testtask.domain.models.Data
import com.example.testtask.presentation.AppViewModel
import com.example.testtask.presentation.components.PulseLoader

@Composable
fun MainScreen(
    appViewModel: AppViewModel= hiltViewModel()
){
    val stateData by appViewModel.stateData

    LaunchedEffect(Unit) {
        appViewModel.getData()
    }

    PulseLoader(isLoading = stateData.isLoading)

    stateData.response?.let { response->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3CFCF))
            .padding(vertical = 15.dp)) {
            items(response.data){
                CardItem(it)
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
fun CardItem(data: Data) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .clickable {
                Log.e("SomeTag", "clicked")
            }
            .background(color = Color.White, shape = RoundedCornerShape(20.dp))
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Image(
            painter = rememberImagePainter(data.icon),
            contentDescription = "Photo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(modifier = Modifier.width(15.dp))
        Column(){
            Text(text = data.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(text = data.endDate, fontSize = 14.sp)
        }
    }
}

@Composable
fun LoadingIndicator(isLoading: Boolean){
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Blue)
        }
    }
}