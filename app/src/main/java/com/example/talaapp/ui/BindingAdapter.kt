package com.example.talaapp.ui

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.example.talaapp.R


@BindingAdapter("bindSpinner")
fun Spinner.bindSpiner(entries: List<String>) {
    val arrayAdapter: ArrayAdapter<String> =
        ArrayAdapter(
            this.context,
            R.layout.my_selected_item,
            entries ?: listOf("")
        )
    arrayAdapter.setDropDownViewResource(R.layout.my_dropdown_item)
    this.setAdapter(arrayAdapter)
}

fun Spinner.selected(action: (position:Int) -> Unit) {
    this.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>?) {}
        override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            action(position)
        }
    }
}