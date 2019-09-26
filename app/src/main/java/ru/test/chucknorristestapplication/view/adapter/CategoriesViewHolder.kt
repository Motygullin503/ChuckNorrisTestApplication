package ru.test.chucknorristestapplication.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.test.chucknorristestapplication.R
import ru.test.chucknorristestapplication.view.callback.CategoryCallback

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.categoryName)
    var categoryCallback: CategoryCallback? = null


    fun bind(name: String) {
        itemView.setOnClickListener {
            categoryCallback?.onCategoryClicked(name)
        }
        title.text = name
    }

}