package com.danimota.myfavoritebooks.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.danimota.myfavoritebooks.databinding.ItemBookBinding
import com.danimota.myfavoritebooks.entity.BookEntity
import com.danimota.myfavoritebooks.ui.listener.BookListener
import com.danimota.myfavoritebooks.ui.viewholder.BookViewHolder

class BookAdapter : RecyclerView.Adapter<BookViewHolder>() {

    private var bookList: List<BookEntity> = listOf()
    private lateinit var bookListener: BookListener

    // Cria o elemento de layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       val view = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookViewHolder(view, bookListener)
    }

    // Retorna quantos elementos existem na RecyclerView
    override fun getItemCount(): Int {
        return bookList.size
    }

    // Vincula os dados do livro ao ViewHolder correspondente.
    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bind(bookList[position])
    }
    // Atualização da lista de convidados
    fun updateBooks(list: List<BookEntity>) {
        bookList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: BookListener) {
        bookListener = listener
    }
}