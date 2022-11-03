package com.example.chapter6_mvvm.network

import com.example.chapter6_mvvm.model.DataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<DataCarItem>>
}