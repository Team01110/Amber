package com.example.domain.model

data class Rating(
    val hits: List<AmberItem>,
    val count: Int,
    val rate: Double
)