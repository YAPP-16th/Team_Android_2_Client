package kr.yapp.teamplay.presentation.matchresultinput

import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatSpinner
import androidx.databinding.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import kr.yapp.teamplay.data.matchresultinput.MatchResultInputRepositoryImpl
import kr.yapp.teamplay.domain.usecase.MatchResultInputUseCase
import kr.yapp.teamplay.presentation.util.SingleLiveEvent


class MatchResultInputViewModel(
    private val matchResultInputUseCase: MatchResultInputUseCase =
        MatchResultInputUseCase(MatchResultInputRepositoryImpl())
) : ViewModel() {

    companion object {
        private const val TAG: String = "MatchResultInput"
    }

    private val _onAddScoreTvClick = SingleLiveEvent<Any>()
    val onAddScoreTvClick: LiveData<Any> get() = _onAddScoreTvClick

    private val _onAddRecordTvClick = SingleLiveEvent<Any>()
    val onAddRecordTvClick: LiveData<Any> get() = _onAddRecordTvClick

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun onAddScoreClick() {
        _onAddScoreTvClick.call()
    }

    fun onAddRecordClick() {
        _onAddRecordTvClick.call()
    }
}