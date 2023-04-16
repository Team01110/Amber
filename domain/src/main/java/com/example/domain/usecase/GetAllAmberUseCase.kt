package com.example.domain.usecase

import com.example.domain.repo.Repository

class GetAllAmberUseCase(private val amberRepository: Repository) {
   operator fun invoke() = amberRepository.getAllAmber()

}