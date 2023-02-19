package com.example.vkservices

import com.google.gson.annotations.SerializedName

data class Service (

    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("icon_url")
    val iconUrl: String?,

    @SerializedName("service_url")
    val serviceUrl: String?
    )