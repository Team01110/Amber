package com.example.domain.model

data class ProductItem(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val title: String,
    val rating: Ratings
)