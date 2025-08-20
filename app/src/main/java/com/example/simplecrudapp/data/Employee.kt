package com.example.simplecrudapp.data

data class Employee(
    val id: Int,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val age: Int,
    val position: Position,
    val company: Company
)
