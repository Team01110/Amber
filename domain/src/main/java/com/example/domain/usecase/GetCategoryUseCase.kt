package com.example.domain.usecase

import com.example.domain.repo.Repository
import javax.inject.Inject

class GetCategoryUseCase @Inject constructor(private val repository: Repository){
    fun getCatigory(repository: Repository) = repository
}