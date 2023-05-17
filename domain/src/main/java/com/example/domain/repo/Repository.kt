package com.example.domain.repo

import com.example.domain.model.Jewelery
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllAmber(): Flow<ResultStatus<List<Jewelery>>>
    fun getRecommenAmber():Flow<ResultStatus<List<Jewelery>>>
}