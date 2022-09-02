package com.example.talaapp.data.mappers

import com.example.talaapp.domain.mappers.LoanDomainToPresentationModelMapper
import com.example.talaapp.domain.model.LoanDomainModel
import com.example.talaapp.presentation.model.LoanPresentationModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class LoanDataToPresentationModelMapperTest(
    private val givenInput: LoanDomainModel,
    private val expectedPresentationModel: LoanPresentationModel
) {
    companion object {
        @JvmStatic
        @Parameters
        fun parameters() = listOf(
            arrayOf(
                LoanDomainModel(
                    status = "due",
                    level =  "silver",
                    due = 5600,
                    dueDate = 1563256800000,
                    approved = 0
                ),
                LoanPresentationModel(
                    status = "due",
                    level =  "silver",
                    due = 5600,
                    dueDate = 1563256800000,
                    approved = 0
                )
            ),
            arrayOf(
                LoanDomainModel(
                    status = "paid",
                    level =  "silver",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                ),
                LoanPresentationModel(
                    status = "paid",
                    level =  "silver",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                )
            ),
            arrayOf(
                LoanDomainModel(
                    status = "paid",
                    level =  "gold",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                ),
                LoanPresentationModel(
                    status = "paid",
                    level =  "gold",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                )
            )
        )
    }

    private lateinit var classUnderTest: LoanDomainToPresentationModelMapper

    @Before
    fun setUp() {
        classUnderTest = LoanDomainToPresentationModelMapper()
    }

    @Test
    fun `Given data model When toDomain Then returns expected Domain model`() {
        // When
        val actualPresentationModel = classUnderTest.toPresentation(givenInput)

        // Then
        assertEquals(expectedPresentationModel, actualPresentationModel)
    }
}