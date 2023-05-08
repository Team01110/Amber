package com.example.domain.usecase

import com.example.domain.repo.Repository
import javax.inject.Inject

class GetAllAmberUseCase @Inject constructor(private val amberRepository: Repository) {
   operator fun invoke() = amberRepository.getAllAmber()

}