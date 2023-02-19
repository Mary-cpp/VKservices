package com.example.vkservices

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ServiceList (

    @SerializedName("items")
    @Expose
    val list: List<Service>
    )