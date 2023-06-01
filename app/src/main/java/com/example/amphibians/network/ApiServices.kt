package com.example.amphibians.network

import com.example.amphibians.model.Amphibian
import retrofit2.http.GET


interface ApiServices {

    @GET("android-basics-kotlin-unit-4-pathway-2-project-api.json")
    suspend fun getAmphibianServices(): List<Amphibian>
}



