package com.example.talaapp.data.mappers

import com.example.talaapp.data.model.LoanDataModel
import com.example.talaapp.domain.model.LoanDomainModel

class LoanDataToDomainModelMapper {
    fun toDomain(input: LoanDataModel): LoanDomainModel =
        LoanDomainModel(
            status = input.status,
            level = input.level,
            due = input.due?:0,
            approved = input.approved?:0,
            dueDate = input.dueDate?:0
        )
}
