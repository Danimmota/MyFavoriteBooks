package com.danimota.myfavoritebooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.danimota.myfavoritebooks.databinding.ItemBookBinding
import com.danimota.myfavoritebooks.entity.BookEntity

class BookViewHolder(private val item : ItemBookBinding) : RecyclerView.ViewHolder(item.root) {

    fun bind(book: BookEntity) {
        item.textviewTitle.text = book.title
    }
}