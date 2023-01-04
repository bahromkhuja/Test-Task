package com.example.testtask.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.testtask.presentation.AppViewModel

@Composable
fun DeatailScreen(
    appViewModel: AppViewModel,
    navController: NavHostController
){
    val data by appViewModel.selectedData

    Scaffold(
        topBar = {TopBar(navController)}
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(10.dp)){
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                Image(
                    painter = rememberImagePainter(data.icon),
                    contentDescription = "Photo",
                    modifier = Modifier.size(100.dp)
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Name:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = data.name ?: "")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Start Date:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = data.startDate ?: "")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "End Date:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = data.endDate ?: "")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Object type:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = data.objType ?: "")
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Text(text = "Login required:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(15.dp))
                Text(text = data.loginRequired.toString() ?: "")
            }
        }
    }
}

@Composable
fun TopBar(navController: NavHostController){
    TopAppBar(
        title={
            Text(text = "Back", fontSize = 18.sp)
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "back")
            }
        },
        backgroundColor = Color.Blue,
        contentColor = Color.White
    )
}