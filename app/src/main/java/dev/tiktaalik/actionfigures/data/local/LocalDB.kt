package dev.tiktaalik.actionfigures.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.tiktaalik.actionfigures.model.Figure

@Database(entities = [Figure::class], version = 1, exportSchema = false)
abstract class LocalDB : RoomDatabase() {
    abstract fun figureDao(): FigureDao

    companion object{
        @Volatile
        private var INSTANCE: LocalDB? = null

        fun getDatabase(context: Context): LocalDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LocalDB::class.java,
                    "local_db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}