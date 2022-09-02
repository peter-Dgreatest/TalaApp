package com.example.talaapp.data.mappers

import com.example.talaapp.data.model.LoanDataListModel
import com.example.talaapp.data.model.LoanDataModel
import com.example.talaapp.data.model.LoanStatusDataModel
import com.google.gson.Gson
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class JsonConverterTest{
    private lateinit var classUnderTest: JsonConverter

    val expectedResult = LoanDataListModel(
        listOf(
            LoanStatusDataModel(
                locale = "mx",
                loan = givenLoanDataModel,
                timestamp = 1561253056182,
                username = "test MX",
            ),
            LoanStatusDataModel(
                locale = "mx",
                loan = givenLoanDataModel,
                timestamp = 1560707238252,
                username = "test MX"
            ),
            LoanStatusDataModel(
                locale = "mx",
                loan = LoanDataModel(
                    status = "approved",
                    approved = 5600,
                    dueDate = null,
                    due = null,
                    level = "silver"
                ),
                timestamp = 1560544512825,
                username = "test MX"
            ),
            LoanStatusDataModel(
                locale = "ke",
                loan = LoanDataModel(
                    status = "due",
                    approved = null,
                    dueDate = 1562965200000,
                    due = 11200,
                    level = "silver"
                ),
                timestamp = 1562487461740,
                username = "test KE"
            ),
        )
    )
    @Before
    fun setUp() {
        classUnderTest = JsonConverter(
            Gson()
        )
    }

    @Test
    fun `Given json String When toData Then returns expected Data model`() {
        // When
        val actualResult = classUnderTest.StringToJson(
            "{\n" +
                    "\"loans\": [\n" +
                    "  {\n" +
                    "    \"locale\": \"mx\",\n" +
                    "    \"loan\": {\n" +
                    "      \"status\": \"due\",\n" +
                    "      \"level\": \"silver\",\n" +
                    "      \"due\": 5600,\n" +
                    "      \"dueDate\": 1563256800000\n" +
                    "    },\n" +
                    "    \"timestamp\": 1561253056182,\n" +
                    "    \"username\": \"test MX\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"locale\": \"mx\",\n" +
                    "    \"loan\": {\n" +
                    "      \"status\": \"due\",\n" +
                    "      \"level\": \"silver\",\n" +
                    "      \"due\": 5600,\n" +
                    "      \"dueDate\": 1563256800000\n" +
                    "    },\n" +
                    "    \"timestamp\": 1560707238252,\n" +
                    "    \"username\": \"test MX\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"locale\": \"mx\",\n" +
                    "    \"loan\": {\n" +
                    "      \"status\": \"approved\",\n" +
                    "      \"level\": \"silver\",\n" +
                    "      \"approved\": 5600\n" +
                    "    },\n" +
                    "    \"timestamp\": 1560544512825,\n" +
                    "    \"username\": \"test MX\"\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"locale\": \"ke\",\n" +
                    "    \"loan\": {\n" +
                    "      \"status\": \"due\",\n" +
                    "      \"level\": \"silver\",\n" +
                    "      \"due\": 11200,\n" +
                    "      \"dueDate\": 1562965200000\n" +
                    "    },\n" +
                    "    \"timestamp\": 1562487461740,\n" +
                    "    \"username\": \"test KE\"\n" +
                    "  }" +
                    "]\n" +
                    "}"
        )

        // Then
        assertEquals(expectedResult, actualResult)
    }
}
