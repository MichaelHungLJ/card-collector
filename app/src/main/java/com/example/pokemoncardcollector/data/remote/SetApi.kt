package com.example.pokemoncardcollector.data.remote

import retrofit2.http.GET

interface SetApi {

    @GET("sets")
    suspend fun getAllSets(): SetResponse
}
