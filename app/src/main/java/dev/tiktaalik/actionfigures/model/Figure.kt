package dev.tiktaalik.actionfigures.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "figure_table")
data class Figure(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Int,
    val creationDate: String,
    val origin: String,
    val photo: String,
    val movie: String,
    val description: String,
    val availability: Boolean,
    val colours: ArrayList<String>,
) : Serializable
