package dev.tiktaalik.actionfigures.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface FigureDepotApi {

    @GET("assets")
    suspend fun getData(): Response<CollectedData>
}