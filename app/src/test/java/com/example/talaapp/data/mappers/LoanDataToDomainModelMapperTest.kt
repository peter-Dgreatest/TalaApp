package com.example.talaapp.data.mappers

import com.example.talaapp.data.model.LoanDataModel
import com.example.talaapp.domain.model.LoanDomainModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.junit.runners.Parameterized.Parameters

@RunWith(Parameterized::class)
class LoanDataToDomainModelMapperTest(
    private val givenInput: LoanDataModel,
    private val expectedDomainModel: LoanDomainModel
) {
    companion object {
        @JvmStatic
        @Parameters
        fun parameters() = listOf(
            arrayOf(
                LoanDataModel(
                    status = "due",
                    level =  "silver",
                    due = 5600,
                    dueDate = 1563256800000,
                    approved = 0
                ),
                LoanDomainModel(
                    status = "due",
                    level =  "silver",
                    due = 5600,
                    dueDate = 1563256800000,
                    approved = 0
                )
            ),
            arrayOf(
                LoanDataModel(
                    status = "paid",
                    level =  "silver",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                ),
                LoanDomainModel(
                    status = "paid",
                    level =  "silver",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                )
            ),
            arrayOf(
                LoanDataModel(
                    status = "paid",
                    level =  "gold",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                ),
                LoanDomainModel(
                    status = "paid",
                    level =  "gold",
                    due = 0,
                    dueDate = 0,
                    approved = 0
                )
            )
        )
    }

    private lateinit var classUnderTest: LoanDataToDomainModelMapper

    @Before
    fun setUp() {
        classUnderTest = LoanDataToDomainModelMapper()
    }

    @Test
    fun `Given data model When toDomain Then returns expected Domain model`() {
        // When
        val actualDomainModel = classUnderTest.toDomain(givenInput)

        // Then
        assertEquals(expectedDomainModel, actualDomainModel)
    }
}