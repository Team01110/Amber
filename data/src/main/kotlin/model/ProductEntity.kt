package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.ProductItem
import com.example.domain.model.Ratings
import mapper.DataMapper

@Entity(tableName = "amber")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val title: String,
    val rating: Ratings
) : DataMapper<ProductItem> {
    override fun toDomain() =  ProductItem(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        title = title,
        rating = rating
    )
}