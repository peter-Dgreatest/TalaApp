package com.example.talaapp.di

import com.example.talaapp.ui.mappers.LoanPresentationToUiModelMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object UiModule {
    @Provides
    fun providesLoanPresentationToUiModelMapper() = LoanPresentationToUiModelMapper()
}