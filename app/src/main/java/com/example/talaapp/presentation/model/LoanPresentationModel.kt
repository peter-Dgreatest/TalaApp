package com.example.talaapp.presentation.model

data class LoanPresentationModel(
    val status: String,
    val level: String,
    val due: Int?,
    val approved: Int?,
    val dueDate: Long?
)
