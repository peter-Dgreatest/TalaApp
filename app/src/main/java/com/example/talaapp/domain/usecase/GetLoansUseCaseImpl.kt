package com.example.talaapp.domain.usecase

import com.example.talaapp.domain.LoanRepository
import com.example.talaapp.domain.model.LoanStatusDomainModel

interface GetLoansUseCase {
    suspend fun executeInBackground(): List<LoanStatusDomainModel>
}

class GetLoansUseCaseImpl(
    private val loanRepository: LoanRepository
) : GetLoansUseCase {
    override suspend fun executeInBackground() =
        loanRepository.fetch()

}
