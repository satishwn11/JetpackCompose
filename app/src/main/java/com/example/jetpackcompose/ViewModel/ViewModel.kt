package com.example.jetpackcompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.Model.Repository

class viewModel() : ViewModel() {

    private val repository = Repository()

    private val _fruits = MutableLiveData<String>()
    val fruit: LiveData<String> = _fruits

    fun loadFruits() {
       _fruits.value = repository.getFruits()
    }
}