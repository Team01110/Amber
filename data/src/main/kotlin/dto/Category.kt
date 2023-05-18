package dto

import com.example.domain.model.ItemModel

data class Category(
    val items: List<ItemModel>,
    val titleCategory: String
)