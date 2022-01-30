package com.example.chucknorrisjokes

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("random")
    fun getData() : Call<List<Value>>
}