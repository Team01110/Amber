package dto

import com.example.domain.model.Category
import com.example.domain.model.Product

data class Jewelery(
    val category: List<Category>,
    val products: List<Product>
)