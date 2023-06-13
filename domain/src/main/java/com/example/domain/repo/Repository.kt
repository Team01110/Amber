package com.example.domain.repo

import com.example.domain.model.Category
import com.example.domain.model.Product
import com.example.domain.utils.ResultStatus
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getProducts(): Flow<ResultStatus<List<Product>>>
    fun getProductsRoom(): Flow<ResultStatus<List<Product>>?>
    suspend fun getCategory(): Flow<ResultStatus<List<Category>>>

    fun insertProduct(product: Product): Flow<ResultStatus<Unit>?>
}