package ru.test.chucknorristestapplication.view.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.test.chucknorristestapplication.R

class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val cover: TextView = itemView.findViewById(R.id.categoryName)

    fun bind(name: String) {
        cover.text = name
    }

}