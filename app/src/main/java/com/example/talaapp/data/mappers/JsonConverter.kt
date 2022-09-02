package com.example.talaapp.data.mappers

import com.example.talaapp.data.model.LoanDataListModel
import com.google.gson.Gson


class JsonConverter(
    private val jsonConverter: Gson
) {
    fun StringToJson(text: String) : LoanDataListModel =
        jsonConverter.fromJson(text, LoanDataListModel::class.java)
}
