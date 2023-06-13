package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val descriptionProduct: String,
    val imageProduct: String,
    val price: String,
    val rating: String,
    val titleProduct: String,
    var quantity: String
)