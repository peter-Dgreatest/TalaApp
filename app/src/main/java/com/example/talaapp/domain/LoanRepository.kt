package com.example.talaapp.domain

import com.example.talaapp.domain.model.LoanStatusDomainModel

interface LoanRepository {
    fun fetch() : List<LoanStatusDomainModel>
}
