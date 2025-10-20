package com.example.jetpackcompose.Model

class Repository() {
    fun getFruits(): String {
        val fruits = listOf(
            "apple","banana","lemon","coconut"
        )
        return fruits.random()
    }
}