package com.example.domain.repo

import com.example.domain.model.AmberItem
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun getAllAmber(): Flow<List<AmberItem>>
}