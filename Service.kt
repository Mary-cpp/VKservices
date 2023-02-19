package com.example.vkservices

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Service (

    @SerializedName("name")
    @Expose
    val name: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @SerializedName("icon_url")
    @Expose
    val iconUrl: String?,

    @SerializedName("service_url")
    @Expose
    val serviceUrl: String?
    )