package com.example.api

import com.example.api.services.CmediumAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CmediumClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(CmediumAPI::class.java)
}