package local

import androidx.room.Database
import androidx.room.RoomDatabase
import model.AmberEntity

@Database(entities = [AmberEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
   abstract fun amberDao():AmberDao
}