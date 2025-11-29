package com.danimota.myfavoritebooks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danimota.myfavoritebooks.entity.BookEntity
import com.danimota.myfavoritebooks.repository.BookRepository

class DetailsViewModel : ViewModel() {

    // Acesso a dados
    private val repository = BookRepository.getInstance()

    // Livro que será carregado
    private val _book = MutableLiveData<BookEntity>()
    val book: LiveData<BookEntity> = _book

    // Livro que será removido
    private val _bookDeleted = MutableLiveData<Boolean>()
    val bookDeleted: LiveData<Boolean> = _bookDeleted

    // Carrega livro do repositório
    fun getBook(bookId: Int) {
        _book.value = repository.getBookById(bookId)
    }

    // Atualiza boolean de favorito
    fun favorite(bookId: Int) {
        repository.toggleFavoriteStatus(bookId)
    }

    // Faz a remoção do libro por ID
    fun delete(bookId: Int) {
        _bookDeleted.value = repository.deleteBook(bookId)
    }
}