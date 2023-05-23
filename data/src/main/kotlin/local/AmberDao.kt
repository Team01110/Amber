package local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dto.Item
import model.Product

@Dao
interface AmberDao {
    @Query("SELECT * FROM Product")
    suspend fun getAllAmber():List<Product>

    @Insert
    suspend fun insertProduct(product: Product)
}