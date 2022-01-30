package com.example.chucknorrisjokes

data class Value(
    val categories: List<String>,
    val id: Int,
    val joke: String?=null
)