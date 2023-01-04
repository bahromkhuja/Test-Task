package com.example.testtask.domain.repository

import com.example.testtask.domain.DataResponse


interface GetDataRepository {
    suspend fun getData(): DataResponse
}