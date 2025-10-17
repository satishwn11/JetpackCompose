package com.example.jetpackcompose.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcompose.Model.UserData
import com.example.jetpackcompose.Model.UserRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {

    val userRepository : UserRepository = UserRepository()

    private val _userData = MutableLiveData<UserData>()
    val userData : LiveData<UserData> = _userData

    fun getUserData(){
        viewModelScope.launch {
            val userResult = userRepository.fetchUserData()
            _userData.postValue(userResult)
        }
    }
}