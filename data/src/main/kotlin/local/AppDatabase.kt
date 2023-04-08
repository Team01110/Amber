package local

import androidx.room.Database
import model.AmberEntity

@Database(entities = [AmberEntity::class], version = 1)
abstract class AppDatabase {
   abstract fun amberDao():AmberDao
}