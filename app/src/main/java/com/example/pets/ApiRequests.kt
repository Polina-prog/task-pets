package com.example.pets

import retrofit2.Response
import retrofit2.http.GET

interface ApiRequests {
    @GET("image/random/10")
    suspend fun getBreeds(): Response<Repo>
}