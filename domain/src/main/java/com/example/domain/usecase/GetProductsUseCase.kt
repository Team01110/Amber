package com.example.domain.usecase

import com.example.domain.repo.Repository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val amberRepository: Repository) {
    suspend operator fun invoke() = amberRepository.getProducts()


}