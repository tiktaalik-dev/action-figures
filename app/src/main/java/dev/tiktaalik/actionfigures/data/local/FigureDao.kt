package dev.tiktaalik.actionfigures.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@androidx.room.Dao
interface FigureDao {
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.Companion.IGNORE)
    fun insertAsset(assetEntity: com.example.crypto.data.local.AssetEntity)

    @androidx.room.Update
    fun updateAsset(assetEntity: com.example.crypto.data.local.AssetEntity)

    @androidx.room.Query("SELECT * FROM asset_table ORDER BY cast(rank as unsigned) asc")
    fun getRankedAssets(): LiveData<List<com.example.crypto.data.local.AssetEntity>>

    @androidx.room.Query("SELECT * FROM asset_table WHERE id = :id")
    fun getAsset(id: String): LiveData<com.example.crypto.data.local.AssetEntity>

    @androidx.room.Query("DELETE FROM asset_table")
    fun deleteAssets()
}