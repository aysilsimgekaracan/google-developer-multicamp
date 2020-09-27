package com.aysilsimgekaracan.googledevelopermulticampcapstoneproject.data.model

import retrofit2.http.GET
import java.util.*

interface CommunitiesAPI {
    @GET("communities")
    suspend fun getCommunities () : List<Communities.CommunitiesResponse>
}