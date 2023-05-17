package local

import androidx.room.Database
import androidx.room.RoomDatabase
import model.Jewelery

@Database(entities = [Jewelery::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
   abstract fun amberDao():AmberDao
}