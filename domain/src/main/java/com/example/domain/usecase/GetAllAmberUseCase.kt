package com.example.domain.usecase

import com.example.domain.model.AmberItem
import com.example.domain.repo.Repository
import javax.inject.Inject

class GetAllAmberUseCase @Inject constructor(private val amberRepository: Repository) {
    fun getAllAmber(amberItem: AmberItem){
        amberRepository.getAllAmber()
    }
}