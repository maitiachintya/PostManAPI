package com.example.postmanapi.util

import com.example.postmanapi.model.Data
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Query

interface APIService {
    @POST("/fetch_video_tab_group_wise")
    open fun postData(@Query("Keydata") Keydata : Long) : Call<com.example.postmanapi.model.Response>
}