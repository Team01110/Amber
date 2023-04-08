package local

import androidx.room.Dao
import androidx.room.Query
import model.AmberEntity

@Dao
interface AmberDao {
    @Query("SELECT * FROM amber")
    suspend fun getAllAmber():List<AmberEntity>
}