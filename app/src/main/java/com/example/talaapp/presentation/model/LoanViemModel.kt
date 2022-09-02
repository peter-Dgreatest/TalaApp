package com.example.talaapp.presentation.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.talaapp.domain.mappers.LoanStatusDomainToPresentationModelMapper
import com.example.talaapp.domain.usecase.GetLoansUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoanViemModel @Inject constructor(
    private val getLoansUseCase: GetLoansUseCase,
    private val loanStatusDomainToPresentationModelMapper: LoanStatusDomainToPresentationModelMapper
) : ViewModel() {

    fun filterBy(filterString: String) {
        val split = filterString.split("-")
        filtered.value = loans.value?.first {
                it ->
                    it.username == split[0].trim() &&
                            it.loan?.status.toString() == split[1].trim() &&
                            it.loan?.due.toString() == split[2].trim()
        }
    }


    val filtered = MutableLiveData<LoanStatusPresentationModel>()

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    //public
    val loans = MutableLiveData<List<LoanStatusPresentationModel>>()
    val userNames : List<String>?
        get() =
            loans.value?.map { it.username }


    init {
        viewModelScope.launch {
            loans.value = getLoansUseCase.executeInBackground().map { loanStatusDomainToPresentationModelMapper.toPresentation(it) }
        }
    }
}