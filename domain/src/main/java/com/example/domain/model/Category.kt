package com.example.domain.model

data class Category(
    val items: List<Product>,
    val titleCategory: String,
    val imageCategory: String
) : java.io.Serializable