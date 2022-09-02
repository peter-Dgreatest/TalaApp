package com.example.talaapp.di

import com.example.talaapp.data.mappers.LoanDataToDomainModelMapper
import com.example.talaapp.data.mappers.LoanStatusDataToDomainModelMapper
import com.example.talaapp.domain.LoanRepository
import com.example.talaapp.domain.usecase.GetLoansUseCase
import com.example.talaapp.domain.usecase.GetLoansUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    fun provideGetLoansUseCase(
        loanRepository: LoanRepository
    ) : GetLoansUseCase = GetLoansUseCaseImpl(
        loanRepository = loanRepository
    )
}