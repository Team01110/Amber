package com.example.domain.model

data class Product(
    val id: Int? = null,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: String,
    val rating: String,
    val titleProduct: String,
    var quantity: String
) : java.io.Serializable