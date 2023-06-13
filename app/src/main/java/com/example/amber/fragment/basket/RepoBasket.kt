package com.example.amber.fragment.basket

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class RepoBasket {
    fun counting(count: Int): LiveData<Int> {
        val livedata = MutableLiveData<Int>()
        livedata.value = count
        return livedata
    }
}