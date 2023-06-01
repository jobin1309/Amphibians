package com.example.amphibians.repository

import com.example.amphibians.model.Amphibian
import com.example.amphibians.network.ApiServices
import javax.inject.Inject

class AnimalRepo @Inject constructor(private val apiServices: ApiServices){

    suspend fun getAmphibianList(): List<Amphibian> {
        return apiServices.getAmphibianServices()
    }
}