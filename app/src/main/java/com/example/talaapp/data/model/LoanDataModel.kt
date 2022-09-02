package com.example.talaapp.data.model

data class LoanDataModel(
    val status: String,
    val level: String,
    val due: Int? = 0,
    val approved: Int?,
    val dueDate: Long? = 0
)
