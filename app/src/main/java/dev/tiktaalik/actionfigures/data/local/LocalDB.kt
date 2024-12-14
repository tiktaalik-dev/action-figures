package dev.tiktaalik.actionfigures.data.local

import android.content.Context

@androidx.room.Database(entities = [com.example.crypto.data.local.AssetEntity::class], version = 1, exportSchema = false)
abstract class LocalDB : androidx.room.RoomDatabase() {
    abstract fun assetDao(): com.example.crypto.data.local.AssetDao

    companion object{
        @Volatile
        private var INSTANCE: LocalDB? = null

        fun getDatabase(context: Context): LocalDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = androidx.room.RoomDatabase.Builder.build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}