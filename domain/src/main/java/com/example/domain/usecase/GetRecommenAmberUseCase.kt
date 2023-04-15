package com.example.domain.usecase

import com.example.domain.repo.Repository

class GetRecommenAmberUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getRecommenAmber()
}