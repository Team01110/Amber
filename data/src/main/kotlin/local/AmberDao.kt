package local

import androidx.room.Dao
import androidx.room.Query
import dto.MainResponceItem
import dto.MainResponse

@Dao
interface AmberDao {
    @Query("SELECT * FROM mainResponceItem ")
    suspend fun getAllAmber():MainResponse<MainResponceItem>
}