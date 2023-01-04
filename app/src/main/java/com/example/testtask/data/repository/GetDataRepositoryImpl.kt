package com.example.testtask.data.repository

import com.example.testtask.data.ApplicationApi
import com.example.testtask.domain.DataResponse
import com.example.testtask.domain.repository.GetDataRepository

class GetDataRepositoryImpl(private val api: ApplicationApi): GetDataRepository {
    override suspend fun getData(): DataResponse = api.getData()
}