package com.example.talaapp.di

import com.example.talaapp.data.LoanDataRepository
import com.example.talaapp.data.mappers.JsonConverter
import com.example.talaapp.data.LoanDataSource
import com.example.talaapp.data.mappers.LoanDataToDomainModelMapper
import com.example.talaapp.data.mappers.LoanStatusDataToDomainModelMapper
import com.example.talaapp.domain.LoanRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    private val gson = Gson()


    @Provides
    fun providesJsonConverter() = JsonConverter(gson)

    @Provides
    fun providesLoanStatusDataToDomainModelMapper(
        loanDataToDomainModelMapper: LoanDataToDomainModelMapper
    ) = LoanStatusDataToDomainModelMapper(
        loanDataToDomainModelMapper = loanDataToDomainModelMapper
    )


    @Provides
    fun providesLoanDataToDomainModelMapper() = LoanDataToDomainModelMapper()

    @Provides
    fun providesLoanDataSource(
        jsonConverter: JsonConverter
    ) = LoanDataSource(
        jsonConverter
    )

    @Provides
    fun provideLoanDataRepository(
        loanDataSource: LoanDataSource,
        loanStatusDataToDomainModelMapper: LoanStatusDataToDomainModelMapper
    ) : LoanRepository = LoanDataRepository(
        loanDataSource = loanDataSource,
        loanStatusDataToDomainModelMapper = loanStatusDataToDomainModelMapper
    )
}