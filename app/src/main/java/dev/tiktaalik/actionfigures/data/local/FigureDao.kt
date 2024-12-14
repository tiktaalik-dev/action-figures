package dev.tiktaalik.actionfigures.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.tiktaalik.actionfigures.model.Figure

@Dao
interface FigureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertEntity(figureEntity: Figure)

    @Update
    fun updateEntity(figureEntity: Figure)

    @Query("SELECT * FROM figure_table ORDER BY cast(price as unsigned) asc")
    fun getFiguresByPrice(): LiveData<List<Figure>>

    @Query("SELECT * FROM figure_table WHERE id = :id")
    fun getEntity(id: String): LiveData<Figure>

    @Query("DELETE FROM figure_table")
    fun deleteEntity()
}