package com.example.talaapp.data.mappers

import com.example.talaapp.data.model.LoanStatusDataModel
import com.example.talaapp.domain.model.LoanStatusDomainModel

class LoanStatusDataToDomainModelMapper(
    private val loanDataToDomainModelMapper: LoanDataToDomainModelMapper
) {
    fun toDomain(input: LoanStatusDataModel): LoanStatusDomainModel {
        return LoanStatusDomainModel(
            locale = input.locale,
            loan = input.loan?.let { loanDataToDomainModelMapper.toDomain(it) },
            timestamp = input.timestamp,
            username = input.username
        )
    }
}
