package local

import androidx.room.Dao
import androidx.room.Query

@Dao
interface AmberDao {
    @Query("SELECT * FROM amber")
    suspend fun getAllAmber():List<model.Jewelery>
}