package com.example.talaapp.data

import com.example.talaapp.data.mappers.LoanStatusDataToDomainModelMapper
import com.example.talaapp.domain.LoanRepository

class LoanDataRepository(
    private val loanDataSource: LoanDataSource,
    private val loanStatusDataToDomainModelMapper: LoanStatusDataToDomainModelMapper
) : LoanRepository {
    override fun fetch() =
        loanDataSource.fetch().loans.map{
            loanStatusDataToDomainModelMapper.toDomain(it)
        }
}
