package local

import androidx.room.Database
import androidx.room.RoomDatabase
import dto.MainResponceItem

@Database(entities = [MainResponceItem::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
   abstract fun amberDao():AmberDao
}