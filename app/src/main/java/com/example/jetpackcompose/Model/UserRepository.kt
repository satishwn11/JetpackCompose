package com.example.jetpackcompose.Model

import kotlinx.coroutines.delay

class UserRepository {

 suspend fun fetchUserData() : UserData {
        delay(2000)
        return UserData("Satish", 22)
    }
}