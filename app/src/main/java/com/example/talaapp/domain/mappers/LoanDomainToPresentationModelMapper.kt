package com.example.talaapp.domain.mappers

import com.example.talaapp.domain.model.LoanDomainModel
import com.example.talaapp.presentation.model.LoanPresentationModel

class LoanDomainToPresentationModelMapper {
    fun toPresentation(input: LoanDomainModel): LoanPresentationModel =
        LoanPresentationModel(
            status = input.status,
            level = input.level,
            due = input.due,
            approved = input.approved?:0,
            dueDate = input.dueDate
        )
}
