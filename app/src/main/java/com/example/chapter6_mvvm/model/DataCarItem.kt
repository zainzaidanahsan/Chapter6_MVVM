package com.example.chapter6_mvvm.model

import com.google.gson.annotations.SerializedName

data class DataCarItem(
    @SerializedName("category")
    val category: String,
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("finish_rent_at")
    val finishRentAt: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("start_rent_at")
    val startRentAt: Any,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("updatedAt")
    val updatedAt: String
)