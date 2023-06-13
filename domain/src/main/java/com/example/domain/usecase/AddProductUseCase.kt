package com.example.domain.usecase

import com.example.domain.model.Product
import com.example.domain.repo.Repository
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val repository: Repository
) {
    operator fun invoke(product: Product) =
        repository.insertProduct(product)
}