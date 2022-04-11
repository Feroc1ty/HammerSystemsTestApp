package ru.rykunov.hammersystemstestapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.rykunov.hammersystemstestapp.MainActivity
import ru.rykunov.hammersystemstestapp.R
import ru.rykunov.hammersystemstestapp.databinding.MealsItemsBinding
import ru.rykunov.hammersystemstestapp.pojo.Meals

class MealsAdapter(mainActivity: MainActivity) : RecyclerView.Adapter<MealsAdapter.NewsViewHolder>() {
    private var mealsList = ArrayList<Meals>()

    fun setMeals(mealslistarray: ArrayList<Meals>){
        this.mealsList = mealslistarray
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(MealsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        if (mealsList[position].strMealThumb != null){
            Glide.with(holder.itemView)
                .load(mealsList[position].strMealThumb)
                .into(holder.binding.imMeal)
        }
        else holder.binding.imMeal.setImageResource(R.drawable.img)
        holder.binding.tvTitle.setText(mealsList[position].strMeal)

    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    class NewsViewHolder(val binding: MealsItemsBinding): RecyclerView.ViewHolder(binding.root)
}