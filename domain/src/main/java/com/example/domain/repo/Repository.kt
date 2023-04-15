package com.example.domain.repo

import com.example.domain.model.AmberItem
import com.example.domain.model.Rating
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllAmber(): Flow<ResultStatus<List<AmberItem>>>
    fun getRecommenAmber():Flow<ResultStatus<List<AmberItem>>>
}