package com.example.talaapp.domain.mappers

import com.example.talaapp.domain.model.LoanDomainModel
import com.example.talaapp.domain.model.LoanStatusDomainModel
import com.example.talaapp.presentation.model.LoanPresentationModel
import com.example.talaapp.presentation.model.LoanStatusPresentationModel
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule

val givenLoanDomainModel = LoanDomainModel(
    status = "due",
    level =  "silver",
    due = 5600,
    dueDate = 1563256800000,
    approved = 0
)

val expectedLoanPresentationModel = LoanPresentationModel(
    status = "due",
    level =  "silver",
    due = 5600,
    dueDate = 1563256800000,
    approved = 0
)


@RunWith(Parameterized::class)
class LoanStatusDomainToPresentationModelMapperTest(
    private val givenInput: LoanStatusDomainModel,
    private val expectedPresentationModel: LoanStatusPresentationModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() = listOf(
            arrayOf(
                LoanStatusDomainModel(
                    locale = "mx",
                    loan = givenLoanDomainModel,
                    timestamp = 1561253056482,
                    username = "test MX"
                ),
                LoanStatusPresentationModel(
                    locale = "mx",
                    loan = expectedLoanPresentationModel,
                    timestamp = 1561253056482,
                    username = "test MX"
                )
            ),
            arrayOf(
                LoanStatusDomainModel(
                    locale = "ke",
                    loan = givenLoanDomainModel,
                    timestamp = 1562487461740,
                    username = "test KE"
                ),
                LoanStatusPresentationModel(
                    locale = "ke",
                    loan = expectedLoanPresentationModel,
                    timestamp = 1562487461740,
                    username = "test KE"
                )
            ),
            arrayOf(
                LoanStatusDomainModel(
                    locale = "ph",
                    loan = givenLoanDomainModel,
                    timestamp = 1562487461740,
                    username = "test Ph"
                ),
                LoanStatusPresentationModel(
                    locale = "ph",
                    loan = expectedLoanPresentationModel,
                    timestamp = 1562487461740,
                    username = "test Ph"
                )
            )
        )
    }

    private lateinit var classUnderTest: LoanStatusDomainToPresentationModelMapper

    @Mock
    lateinit var loanDomainToPresentationModelMapper: LoanDomainToPresentationModelMapper

    @get:Rule
    val mockitoRules: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUp() {
        classUnderTest = LoanStatusDomainToPresentationModelMapper(
             loanDomainToPresentationModelMapper
        )
    }

    @Test
    fun `Given data model When toDomain Then returns expected Domain model`() {
        given(loanDomainToPresentationModelMapper.toPresentation(givenLoanDomainModel)).
        willReturn(expectedLoanPresentationModel)

        // When
        val actualPresentationModel = classUnderTest.toPresentation(givenInput)

        // Then
        assertEquals(expectedPresentationModel, actualPresentationModel)
    }
}