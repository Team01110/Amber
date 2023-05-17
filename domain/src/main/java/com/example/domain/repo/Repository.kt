package com.example.domain.repo

import com.example.domain.model.Category
import com.example.domain.model.ItemModel
import com.example.domain.model.Jewelery
import com.example.domain.model.Product
import com.example.domain.utils.ResultStatus
import dagger.internal.codegen.validation.ValidationReport.Item
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getProducts(): Flow<ResultStatus<List<Product>>>
    suspend fun getCategory(): Flow<ResultStatus<List<Category>>>
}