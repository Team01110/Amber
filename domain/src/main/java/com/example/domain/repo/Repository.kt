package com.example.domain.repo

import com.example.domain.model.ProductItem
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllAmber(): Flow<ResultStatus<List<ProductItem>>>
}