//package com.example.calender.data.di
//
//import com.example.calender.data.ApiInterface
//import com.example.calender.data.WeatherRepositoryimpl
//import com.example.calender.domain.WeatherRepository
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//    @Provides
//    fun providesWeatherRepository(
//        apiInterface: ApiInterface
//    ): WeatherRepository = WeatherRepositoryimpl(apiInterface)
//}