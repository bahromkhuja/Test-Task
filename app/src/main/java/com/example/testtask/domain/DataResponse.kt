package com.example.testtask.domain

import com.example.testtask.domain.models.Data

data class DataResponse(
    val `data`: List<Data>,
    val total: String
)