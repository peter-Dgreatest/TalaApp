package com.example.talaapp.domain.model

data class LoanDomainModel(
    val status: String,
    val level: String,
    val due: Int? = 0,
    val approved: Int?,
    val dueDate: Long? = 0
)
