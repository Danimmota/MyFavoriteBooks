package com.danimota.myfavoritebooks.ui.listener

interface BookListener {
    fun onClick(id: Int)
    fun onFavorite(id: Int)
}