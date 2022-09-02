package com.example.talaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.talaapp.databinding.ActivityMainBinding
import com.example.talaapp.presentation.model.LoanViemModel
import com.example.talaapp.ui.bindSpiner
import com.example.talaapp.ui.cardviews.TalaDreamCardView
import com.example.talaapp.ui.cardviews.TalaDueLoanCardView
import com.example.talaapp.ui.cardviews.TalaStatusCardView
import com.example.talaapp.ui.cardviews.TalaTopCardView
import com.example.talaapp.ui.mappers.LoanPresentationToUiModelMapper
import com.example.talaapp.ui.models.LoanUIModel
import com.example.talaapp.ui.selected
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: LoanViemModel by viewModels()
    val topCardView: TalaTopCardView by lazy {findViewById(R.id.topCardView)}
    val dueLoanCardView: TalaDueLoanCardView by lazy {findViewById(R.id.dueCardView)}
    val statusCardView: TalaStatusCardView by lazy {findViewById(R.id.statusCardView)}
    val dreamCardView: TalaDreamCardView by lazy {findViewById(R.id.dreamCardView)}

    @Inject
    lateinit var loanPresentationToUiModelMapper: LoanPresentationToUiModelMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        binding.selectionSpinner.selected {
            viewModel.filterBy(binding.selectionSpinner.selectedItem.toString())
        }

        viewModel.filtered.observe(this){
            updateUI(
                loanPresentationToUiModelMapper.toUI(
                    it
                )
            )
        }

        viewModel.loans.observe(this){
            loan->
            if (loan != null){
                val userNamesWithLoans = loan.shuffled().map { "${it.username} - ${it.loan?.status} - ${it.loan?.due}" }

                binding.selectionSpinner.bindSpiner(userNamesWithLoans)

                val uiModel = loan.shuffled().map { loanPresentationToUiModelMapper.toUI(it) }.first()
                updateUI(uiModel)
            }
        }

        binding.viewModel = viewModel
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_tala_circle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    fun updateUI(uiModel: LoanUIModel){
        if(uiModel.loanStatusUiModel.dueDate?.length!! >3) {
            dueLoanCardView.bindData(uiModel.loanStatusUiModel)
            dueLoanCardView.visibility = View.VISIBLE
            topCardView.visibility = View.GONE
        }
        else {
            topCardView.bindData(uiModel.loanStatusUiModel)
            topCardView.visibility = View.VISIBLE
            dueLoanCardView.visibility = View.GONE
        }
        statusCardView.bindData(uiModel.statusInfoUiModel)
        dreamCardView.bindData(uiModel.dreamColumnUiModel)
    }
}