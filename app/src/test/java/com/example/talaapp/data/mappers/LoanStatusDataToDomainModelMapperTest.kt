package com.example.talaapp.data.mappers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.talaapp.data.model.LoanDataModel
import com.example.talaapp.data.model.LoanStatusDataModel
import com.example.talaapp.domain.model.LoanDomainModel
import com.example.talaapp.domain.model.LoanStatusDomainModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.BDDMockito.given
import org.mockito.Mock

val givenLoanDataModel = LoanDataModel(
    status = "due",
    level =  "silver",
    due = 5600,
    dueDate = 1563256800000,
    approved = null
)

val expectedLoanDomainModel = LoanDomainModel(
    status = "due",
    level =  "silver",
    due = 5600,
    dueDate = 1563256800000,
    approved = null
)


@RunWith(Parameterized::class)
class LoanStatusDataToDomainModelMapperTest(
    private val givenInput: LoanStatusDataModel,
    private val expectedDomainModel: LoanStatusDomainModel
) {
    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() = listOf(
            arrayOf(
                LoanStatusDataModel(
                    locale = "mx",
                    loan = givenLoanDataModel,
                    timestamp = 1561253056482,
                    username = "test MX"
                ),
                LoanStatusDomainModel(
                    locale = "mx",
                    loan = expectedLoanDomainModel,
                    timestamp = 1561253056482,
                    username = "test MX"
                )
            ),
            arrayOf(
                LoanStatusDataModel(
                    locale = "ke",
                    loan = givenLoanDataModel,
                    timestamp = 1562487461740,
                    username = "test KE"
                ),
                LoanStatusDomainModel(
                    locale = "ke",
                    loan = expectedLoanDomainModel,
                    timestamp = 1562487461740,
                    username = "test KE"
                )
            ),
            arrayOf(
                LoanStatusDataModel(
                    locale = "ph",
                    loan = givenLoanDataModel,
                    timestamp = 1562487461740,
                    username = "test Ph"
                ),
                LoanStatusDomainModel(
                    locale = "ph",
                    loan = expectedLoanDomainModel,
                    timestamp = 1562487461740,
                    username = "test Ph"
                )
            )
        )
    }

    private lateinit var classUnderTest: LoanStatusDataToDomainModelMapper

    @Mock
    lateinit var loanDataToDomainModelMapper: LoanDataToDomainModelMapper


    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        classUnderTest = LoanStatusDataToDomainModelMapper(
            loanDataToDomainModelMapper
        )
    }

    @Test
    fun `Given data model When toDomain Then returns expected Domain model`() {
        given(loanDataToDomainModelMapper.toDomain(givenLoanDataModel)).
                willReturn(expectedLoanDomainModel)

        // When
        val actualDomainModel = classUnderTest.toDomain(givenInput)

        // Then
        assertEquals(expectedDomainModel, actualDomainModel)
    }
}