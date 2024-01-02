package com.example.postmanapi.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val retrofit: APIService by lazy {
        Retrofit.Builder()
            .baseUrl(Constance.base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService :: class.java)
    }
}