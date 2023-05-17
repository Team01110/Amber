package local

import androidx.room.Database
import androidx.room.RoomDatabase
import dto.Item

@Database(entities = [Item::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
   abstract fun amberDao():AmberDao
}