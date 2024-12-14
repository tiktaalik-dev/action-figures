package dev.tiktaalik.actionfigures.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Figure(
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
) : Parcelable
