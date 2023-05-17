package local

import androidx.room.Dao
import androidx.room.Query
import dto.Item

@Dao
interface AmberDao {
    @Query("SELECT * FROM Item ")
    suspend fun getAllAmber():List<Item>
}