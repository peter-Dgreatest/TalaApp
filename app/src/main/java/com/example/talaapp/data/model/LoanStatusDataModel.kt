package com.example.talaapp.data.model

data class LoanStatusDataModel(
    val locale: String,
    val loan: LoanDataModel?,
    val timestamp: Long,
    val username: String
)

data class LoanDataListModel(
    val loans: List<LoanStatusDataModel>
)