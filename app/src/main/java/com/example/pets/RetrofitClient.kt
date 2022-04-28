package com.example.pets

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val retrofitClient = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service = retrofitClient.create(ApiRequests::class.java)
}