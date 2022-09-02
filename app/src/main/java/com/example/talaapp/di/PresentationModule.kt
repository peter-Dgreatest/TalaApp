package com.example.talaapp.di

import com.example.talaapp.domain.mappers.LoanDomainToPresentationModelMapper
import com.example.talaapp.domain.mappers.LoanStatusDomainToPresentationModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object PresentationModule {

    @Provides
    fun providesLoanDomainToPresentationModelMapper() = LoanDomainToPresentationModelMapper()

    @Provides
    fun providesLoanStatusDomainToPresentationModelMapper(
        loanDomainToPresentationModelMapper: LoanDomainToPresentationModelMapper
    ) = LoanStatusDomainToPresentationModelMapper(
        loanDomainToPresentationModelMapper = loanDomainToPresentationModelMapper
    )
}