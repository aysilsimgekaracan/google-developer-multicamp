package com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.data.model

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create

object RetrofitProvider {
    private val contentType: MediaType = MediaType.get("application/json")

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://5f6642a143662800168e7538.mockapi.io/multicamp/")
        .addConverterFactory(Json {
            ignoreUnknownKeys = true
            isLenient = true
            allowSpecialFloatingPointValues = true
            encodeDefaults = false
        }.asConverterFactory(contentType))
        .build()

    //val retrofitApi: CommunitiesAPI by lazy { retrofit.create(CommunitiesAPI::class.java) }

    val retrofitApi = retrofit.create<CommunitiesAPI>()


}