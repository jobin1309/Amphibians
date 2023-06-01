package com.example.amphibians.di

import android.provider.SyncStateContract
import com.example.amphibians.CONSTANTS
import com.example.amphibians.CONSTANTS.Companion.BASE_URL
import com.example.amphibians.network.ApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AmphibianModule {


    @Singleton
    @Provides
    fun provideRetrofitInstance(
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton //optional annotation, when we are specify above
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

}