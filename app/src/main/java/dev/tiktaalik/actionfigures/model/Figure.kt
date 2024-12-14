package dev.tiktaalik.actionfigures.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Figure(
    val id: Int,
    val name: String,
    val price: Int,
    val photo: String,
    val size: Int,
    val renovation: Boolean,
    val credit: Boolean,
    val description: String,
    val cause: String
) : Parcelable
