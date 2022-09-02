package com.example.talaapp.ui.cardviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.talaapp.R
import com.example.talaapp.ui.models.DreamColumnUiModel

class TalaDreamCardView(context: Context, attrs: AttributeSet) : CardView(context, attrs){
    private val titleText : TextView by lazy { findViewById(R.id.title_text_view)}
    private val imageView : View by lazy { findViewById(R.id.container_view)}

    init {
        inflate(getContext(), R.layout.card_view_tala_dream, this)
    }

    fun bindData(
        statusInfo: DreamColumnUiModel
    ) {
        titleText.setEms(statusInfo.fontSize)
        imageView.setBackgroundResource(statusInfo.imageRes)
    }
}