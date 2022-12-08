package com.example.pr26

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RandomNumberViewModel: ViewModel() {
    val currentRandomNumber = MutableLiveData<Int>()

    fun generateNumber() {
        currentRandomNumber.value = (0..50).random()
    }
}