package com.example.talaapp.presentation.model

data class LoanStatusPresentationModel(
    val locale: String,
    val loan: LoanPresentationModel?,
    val timestamp: Long,
    val username: String
)