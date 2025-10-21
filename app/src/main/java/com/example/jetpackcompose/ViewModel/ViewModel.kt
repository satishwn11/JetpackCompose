package com.example.jetpackcompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jetpackcompose.Model.Repository

class viewModel() : ViewModel() {

    private val repository = Repository()

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> = _result

    fun checkVowel(text: String) {
       _result.value = repository.CheckVowels(text)
    }
}