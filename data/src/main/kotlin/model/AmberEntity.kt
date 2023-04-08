package model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amber")
data class AmberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
)