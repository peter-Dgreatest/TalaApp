package com.example.talaapp.domain.model

data class LoanStatusDomainModel(
    val locale: String,
    val loan: LoanDomainModel?,
    val timestamp: Long,
    val username: String
)