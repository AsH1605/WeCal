package com.example.calender.data.di

import com.example.calender.data.RepositoryImpl.WeatherRepositoryImpl
import com.example.calender.data.remote.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideWeatherRepository(apiInterface: ApiInterface): WeatherRepositoryImpl
    = WeatherRepositoryImpl(apiInterface)
}