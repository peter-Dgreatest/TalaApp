package com.example.talaapp.ui.models

data class LoanStatusUiModel(
    val titleText: String,
    val bodyText: String,
    val imageRes: Int,
    val amount: String? = "",
    val dueDate: String? = ""
)
