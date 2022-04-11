package ru.rykunov.hammersystemstestapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.rykunov.hammersystemstestapp.pojo.Meals
import ru.rykunov.hammersystemstestapp.pojo.MealsList
import ru.rykunov.hammersystemstestapp.retrofit.RetrofitInstance

class HomeViewModel(): ViewModel() {

    private var mealsListLiveData = MutableLiveData<List<Meals>>()


    fun getMealsList(){
        RetrofitInstance.api.getMealsList().enqueue(object : Callback<MealsList> {
            override fun onResponse(call: Call<MealsList>, response: Response<MealsList>) {
                if (response.body() != null){
                    mealsListLiveData.value = response.body()!!.meals
                }
            }

            override fun onFailure(call: Call<MealsList>, t: Throwable) {
                Log.d("MyLog", t.message.toString())
            }
        })
    }


    fun observeMealsLiveData(): LiveData<List<Meals>> {
        return mealsListLiveData
    }

}