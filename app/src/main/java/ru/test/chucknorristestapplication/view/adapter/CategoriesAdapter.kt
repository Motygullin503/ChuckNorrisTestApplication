package ru.test.chucknorristestapplication.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.view.callback.CategoryCallback

class CategoriesAdapter : RecyclerView.Adapter<CategoriesViewHolder>() {

    var categoryCallback: CategoryCallback? = null

    var categories: List<String> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {

        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.item_category, parent, false)

        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryCallback = categoryCallback
        holder.bind(category)
    }
}