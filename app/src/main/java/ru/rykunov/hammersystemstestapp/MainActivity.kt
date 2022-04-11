package ru.rykunov.hammersystemstestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.rykunov.hammersystemstestapp.adapter.MealsAdapter
import ru.rykunov.hammersystemstestapp.databinding.ActivityMainBinding
import ru.rykunov.hammersystemstestapp.pojo.Meals
import ru.rykunov.hammersystemstestapp.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var homeMvvm: HomeViewModel
    lateinit var mealsItemsAdapter: MealsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        mealsItemsAdapter = MealsAdapter(this)
        setContentView(binding.root)

        prepareMealsRcView()
        homeMvvm = ViewModelProviders.of(this)[HomeViewModel::class.java]
        homeMvvm.getMealsList()
        observeMealsItemsLiveData()

    }

    /*
    Подготовка Recycler View
    */
    private fun prepareMealsRcView() {
        binding.rcMeals.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = mealsItemsAdapter
        }
    }

    private fun observeMealsItemsLiveData() {
        homeMvvm.observeMealsLiveData().observe(this
        ) { mealsList ->
            mealsItemsAdapter.setMeals(mealslistarray = mealsList as ArrayList<Meals>)
        }

    }
}