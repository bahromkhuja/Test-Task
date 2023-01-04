package com.example.testtask.data

import com.example.testtask.domain.DataResponse
import retrofit2.http.GET


interface ApplicationApi {
    @GET("/service/v2/upcomingGuides/")
    suspend fun getData(): DataResponse
}