package com.danimota.myfavoritebooks.entity

data class BookEntity (
    val id: Long,
    val title: String,
    val author: String,
    var favorite: Boolean,
    val genre: String,
){}