package com.example.testtask.app.di

import com.example.testtask.data.ApplicationApi
import com.example.testtask.data.repository.GetDataRepositoryImpl
import com.example.testtask.domain.repository.GetDataRepository
import com.example.testtask.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApplicationApi(): ApplicationApi =
        Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().addInterceptor(
                    HttpLoggingInterceptor().setLevel(
                        HttpLoggingInterceptor.Level.BODY
                    )
                ).build()
            )
            .build()
            .create(ApplicationApi::class.java)

    @Provides
    @Singleton
    fun provideAppRepository(api: ApplicationApi): GetDataRepository =
        GetDataRepositoryImpl(api)
}