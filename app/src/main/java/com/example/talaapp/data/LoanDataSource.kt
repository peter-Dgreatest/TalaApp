package com.example.talaapp.data

import com.example.talaapp.data.mappers.JsonConverter
import com.example.talaapp.data.model.LoanDataListModel

interface LoanSource {
    fun fetch() : LoanDataListModel
}

class LoanDataSource(
    private val jsonConverter : JsonConverter
): LoanSource {
    override fun fetch() =
        jsonConverter.StringToJson(LOANSDATA)
}

const val LOANSDATA = "{\n" +
        "\"loans\": [\n" +
        "  {\n" +
        "    \"locale\": \"mx\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"due\",\n" +
        "      \"level\": \"silver\",\n" +
        "      \"due\": 5600,\n" +
        "      \"dueDate\": 1563256800000\n" +
        "    },\n" +
        "    \"timestamp\": 1561253056482,\n" +
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
        "    \"timestamp\": 1560707238253,\n" +
        "    \"username\": \"test MX\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"mx\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"approved\",\n" +
        "      \"level\": \"silver\",\n" +
        "      \"approved\": 5000\n" +
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
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ke\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"paid\",\n" +
        "      \"level\": \"silver\"\n" +
        "    },\n" +
        "    \"timestamp\": 1562746791839,\n" +
        "    \"username\": \"test KE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ph\",\n" +
        "    \"timestamp\": 1560583123914,\n" +
        "    \"username\": \"test PH\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ke\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"due\",\n" +
        "      \"level\": \"silver\",\n" +
        "      \"due\": 11200,\n" +
        "      \"dueDate\": 1562965200000\n" +
        "    },\n" +
        "    \"timestamp\": 1561018532937,\n" +
        "    \"username\": \"test KE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"mx\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"paid\",\n" +
        "      \"level\": \"gold\"\n" +
        "    },\n" +
        "    \"timestamp\": 1561253388256,\n" +
        "    \"username\": \"test MX\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"mx\",\n" +
        "    \"timestamp\": 1560544054571,\n" +
        "    \"username\": \"test MX\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ph\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"due\",\n" +
        "      \"level\": \"bronze\",\n" +
        "      \"due\": 740,\n" +
        "      \"dueDate\": 1562601600000\n" +
        "    },\n" +
        "    \"timestamp\": 1561461327614,\n" +
        "    \"username\": \"test PH\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ph\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"paid\",\n" +
        "      \"level\": \"bronze\"\n" +
        "    },\n" +
        "    \"timestamp\": 1562567741317,\n" +
        "    \"username\": \"test PH\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ph\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"approved\",\n" +
        "      \"level\": \"bronze\",\n" +
        "      \"approved\": 4000\n" +
        "    },\n" +
        "    \"timestamp\": 1560839058143,\n" +
        "    \"username\": \"test PH\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"mx\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"approved\",\n" +
        "      \"level\": \"gold\",\n" +
        "      \"approved\": 7000\n" +
        "    },\n" +
        "    \"timestamp\": 1561744093017,\n" +
        "    \"username\": \"test MX\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ke\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"approved\",\n" +
        "      \"level\": \"silver\",\n" +
        "      \"approved\": 16000\n" +
        "    },\n" +
        "    \"timestamp\": 1560332572283,\n" +
        "    \"username\": \"test KE\"\n" +
        "  },\n" +
        "  {\n" +
        "    \"locale\": \"ph\",\n" +
        "    \"loan\": {\n" +
        "      \"status\": \"due\",\n" +
        "      \"level\": \"bronze\",\n" +
        "      \"due\": 740,\n" +
        "      \"dueDate\": 1562601600000\n" +
        "    },\n" +
        "    \"timestamp\": 1562567228207,\n" +
        "    \"username\": \"test PH\"\n" +
        "  }\n" +
        "]\n" +
        "}"
