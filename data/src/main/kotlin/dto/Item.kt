package dto

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.ItemModel
@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var descriptionProduct: String,
    var imageProduct: String,
    var price: String,
    var rating: String,
    var titleProduct: String
){
    fun Item.toDomain(): ItemModel = ItemModel(
        descriptionProduct = descriptionProduct,
        imageProduct = imageProduct,
        price = price,
        rating = rating,
        titleProduct = titleProduct
    )
}