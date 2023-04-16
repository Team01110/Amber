package local

import androidx.room.Database
import androidx.room.RoomDatabase
import model.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
   abstract fun amberDao():AmberDao
}