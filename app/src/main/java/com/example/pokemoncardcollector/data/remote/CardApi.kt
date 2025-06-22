package com.example.pokemoncardcollector.data.remote

import retrofit2.http.GET
import retrofit2.http.Path

interface CardApi {

    @GET("cards/{id}")
    suspend fun getCardById(@Path("id") id: String): CardResponse
}
