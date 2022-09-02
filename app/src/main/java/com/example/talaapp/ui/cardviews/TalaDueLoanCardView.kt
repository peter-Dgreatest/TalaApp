package com.example.talaapp.ui.cardviews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.talaapp.R
import com.example.talaapp.ui.models.LoanStatusUiModel

class TalaDueLoanCardView(context: Context, attrs: AttributeSet) : CardView(context, attrs){

    private val bodyText : TextView by lazy { findViewById(R.id.title_loan_amount)}
    private val dueText : TextView by lazy { findViewById(R.id.body_due_date)}

    init {
        inflate(getContext(), R.layout.card_view_due_loan, this)
    }

    fun bindData(
        statusInfo: LoanStatusUiModel
    ) {
        dueText.text = statusInfo.dueDate
        bodyText.text = statusInfo.amount
    }
}