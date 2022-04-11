package ru.rykunov.hammersystemstestapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: MealsApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://themealdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealsApi::class.java)
    }
}