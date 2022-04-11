package ru.rykunov.hammersystemstestapp.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import ru.rykunov.hammersystemstestapp.pojo.MealsList

interface MealsApi {
    @GET("/api/json/v1/1/filter.php?c=Dessert")
    fun getMealsList(): Call<MealsList>
}