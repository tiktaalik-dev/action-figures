package dev.tiktaalik.actionfigures.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FigureDepotClient {
    companion object {
        private const val BASE_URL = "https://figuras-n900keow2-talento-projects.vercel.app/figuras"

        fun retrofitInstance(): FigureDepotApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(FigureDepotApi::class.java)
        }
    }
}