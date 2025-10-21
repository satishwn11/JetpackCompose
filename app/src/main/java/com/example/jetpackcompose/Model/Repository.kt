package com.example.jetpackcompose.Model

class Repository() {
    fun CheckVowels(word: String) : String {
        val word1 = word.lowercase().trim()
        val vowels = "aeiou"
        var vcounts = 0
        var consonant = 0

        for (ch in word1) {
            if(ch in vowels) {
                vcounts++
            } else {
                consonant++
            }
        }
        return "Vowels: $vcounts"
    }
}