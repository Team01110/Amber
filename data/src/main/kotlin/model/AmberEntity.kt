package model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.AmberItem
import mapper.DataMapper

@Entity(tableName = "amber")
data class AmberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val title: String
) : DataMapper<AmberItem> {
    override fun toDomain() =  AmberItem(
        id = id,
        category = category,
        description = description,
        image = image,
        price = price,
        title = title,
    )
}