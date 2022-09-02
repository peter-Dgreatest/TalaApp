package com.example.talaapp.domain.mappers

import com.example.talaapp.domain.model.LoanStatusDomainModel
import com.example.talaapp.presentation.model.LoanStatusPresentationModel

class LoanStatusDomainToPresentationModelMapper(
    private val loanDomainToPresentationModelMapper: LoanDomainToPresentationModelMapper
) {
    fun toPresentation(input: LoanStatusDomainModel): LoanStatusPresentationModel =
        LoanStatusPresentationModel(
            locale = input.locale,
            loan = input.loan?.let { loanDomainToPresentationModelMapper.toPresentation(it) },
            timestamp = input.timestamp,
            username = input.username
        )
}
