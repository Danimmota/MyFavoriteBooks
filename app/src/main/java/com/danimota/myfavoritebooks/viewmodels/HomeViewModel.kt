package com.danimota.myfavoritebooks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danimota.myfavoritebooks.entity.BookEntity
import com.danimota.myfavoritebooks.repository.BookRepository

class HomeViewModel : ViewModel() {

    private val _books = MutableLiveData<List<BookEntity>>()
        val books: LiveData<List<BookEntity>> = _books
    private val repository = BookRepository()
    fun getAllBooks() {
        _books.value = repository.getAllBooks()
    }
}