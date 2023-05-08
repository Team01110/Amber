package com.example.domain.model


data class ProductItem(
    val id: Int,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: Double,
    val titleProduct: String,
    val rating:Ratings
)