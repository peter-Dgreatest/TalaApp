package com.example.talaapp.ui.cardviews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.talaapp.R
import com.example.talaapp.ui.models.LoanStatusUiModel

class TalaTopCardView(context: Context, attrs: AttributeSet) : CardView(context, attrs){

    private val titleText : TextView by lazy {findViewById(R.id.title_text_view)}
    private val bodyText : TextView by lazy {findViewById(R.id.body_text_view)}
    private val imageView : ImageView by lazy {findViewById(R.id.image_view)}

    init {
        inflate(getContext(), R.layout.card_view_apply_for_a_loan, this)
    }

    fun bindData(
        statusInfo: LoanStatusUiModel
    ) {
        titleText.text = statusInfo.titleText
        bodyText.text = statusInfo.bodyText
        imageView.setImageResource(statusInfo.imageRes)
    }
}