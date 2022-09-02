package com.example.talaapp.ui.mappers

import android.graphics.Typeface
import android.text.SpannableString
import android.text.Spanned
import android.text.style.StyleSpan
import com.example.talaapp.R
import com.example.talaapp.presentation.model.LoanStatusPresentationModel
import com.example.talaapp.ui.models.DreamColumnUiModel
import com.example.talaapp.ui.models.LoanStatusUiModel
import com.example.talaapp.ui.models.LoanUIModel
import com.example.talaapp.ui.models.StatusInfoUiModel


class LoanPresentationToUiModelMapper {
    fun toUI(input: LoanStatusPresentationModel): LoanUIModel =
        LoanUIModel(
            dreamColumnUiModel = when (input.locale) {
                "mx" -> DreamColumnUiModel(
                    imageRes = R.drawable.img_story_card_mx,
                    fontSize = 16
                )
                "ph" -> DreamColumnUiModel(
                    imageRes = R.drawable.img_story_card_ph,
                    fontSize = 16
                )
                else -> DreamColumnUiModel(
                    imageRes = R.drawable.img_story_card_ke,
                    fontSize = 30
                )
            },
            statusInfoUiModel = when (input.loan?.level) {
                "bronze" -> StatusInfoUiModel(
                    imageRes = R.drawable.img_bronze_badge_large,
                    bodyText = getLimitString(input.locale)
                )
                "silver" -> StatusInfoUiModel(
                    imageRes = R.drawable.img_silver_badge_large,
                    bodyText = SpannableString("Track your progress over time")
                )
                else -> StatusInfoUiModel(
                    imageRes = R.drawable.img_gold_badge_large,
                    bodyText = SpannableString("Track your progress over time")
                )
            },
            loanStatusUiModel =
            when (input.loan?.status) {
                "due" -> LoanStatusUiModel(
                    imageRes = R.drawable.img_loan_status_paidoff,
                    bodyText = "",
                    titleText = "",
                    amount = getCurrencyString(input.locale, input.loan?.due!!),
                    dueDate = getDueDateString(input.timestamp, input.loan?.dueDate!!)
                )
                "paid" -> LoanStatusUiModel(
                    imageRes = R.drawable.img_loan_status_paidoff,
                    titleText = "Your loan is fully paid",
                    bodyText = "Apply for another loan at anytime you want and grow your limit"
                )
                "approved" -> LoanStatusUiModel(
                    imageRes = R.drawable.img_loan_status_approved,
                    bodyText = "You've been approved for ${getCurrencyString(input.locale,
                        input.loan?.approved!!
                    )}",
                    titleText = "Your application is Approved"
                )
                else -> LoanStatusUiModel(
                    imageRes = getLocaleDrawable(input.locale),
                    bodyText = "Qualify for loans up to ${getLimit(input.locale)}",
                    titleText = "Apply For a loan"
                )
            }
        )

    // no drawable for the remaining locale
    private fun getLocaleDrawable(locale: String): Int =
        when (locale) {
            "mx" -> R.drawable.img_loan_status_apply
            "ph" -> R.drawable.img_loan_status_apply
            else -> R.drawable.img_loan_status_apply
        }


    private fun getDueDateString(timestamp: Long, dueDate: Long): String {
        var difference = dueDate - timestamp
        difference /= (1000 * 60 * 60 * 24)
        return "due in $difference days"
    }

    private fun getCurrencyString(locale: String,amount: Int) =
        when (locale) {
            "mx" -> "Mxn $amount"
            "ph" -> "Php $amount"
            else -> "Ksh $amount"
        }

    private fun getLimitString(locale: String): SpannableString {
        val limit = getLimit(locale)
        val ss = SpannableString("Grow your limit up to $limit")
        val boldSpan = StyleSpan(Typeface.BOLD)
        ss.setSpan(boldSpan, 21, ss.length-1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        return ss
    }

    private fun getLimit(locale: String): String {
        val limit = when (locale) {
            "mx" -> "Mxn 10,000"
            "ph" -> "Php 25,000"
            else -> "Ksh 50,000"
        }
        return limit
    }
}



