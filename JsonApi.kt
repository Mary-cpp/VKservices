package com.example.vkservices

import retrofit2.Response
import retrofit2.http.GET

const val BASE_URL = "https://mobile-olympiad-trajectory.hb.bizmrg.com/semi-final-data.json/"

interface JsonApi {
    @GET(BASE_URL)
    suspend fun getServices(): Response<List<Service>>
}