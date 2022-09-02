package com.example.talaapp.ui.cardviews

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.talaapp.R
import com.example.talaapp.ui.models.StatusInfoUiModel

class TalaStatusCardView(context: Context, attrs: AttributeSet) : CardView(context, attrs){

    private val bodyText : TextView by lazy { findViewById(R.id.body_text_view)}
    private val imageView : ImageView by lazy { findViewById(R.id.image_view)}

    init {
        inflate(getContext(), R.layout.card_view_my_status, this)
    }

    fun bindData(
        statusInfo: StatusInfoUiModel
    ) {
        bodyText.text = statusInfo.bodyText
        imageView.setImageResource(statusInfo.imageRes)
    }
}