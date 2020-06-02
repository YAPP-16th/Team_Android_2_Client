package kr.yapp.teamplay.presentation.matchresultinput

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.matchresultinput.MatchResultInputRepositoryImpl
import kr.yapp.teamplay.data.matchresultinput.request.PersonalRecordItemRequest
import kr.yapp.teamplay.data.matchresultinput.request.ScoreDetailItemRequest
import kr.yapp.teamplay.domain.entity.matchresultinput.MatchResultInfo
import kr.yapp.teamplay.domain.entity.matchresultinput.PersonalRecordItem
import kr.yapp.teamplay.domain.entity.matchresultinput.ScoreDetailItem
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

    val hostScore = MutableLiveData<String>("0")
    val guestScore = MutableLiveData<String>("0")
    val matchReview = MutableLiveData<String>("")

    val scoreDetailList: ObservableArrayList<ScoreDetailItem> = ObservableArrayList()

    val personalRecordList: ObservableArrayList<PersonalRecordItem> = ObservableArrayList()


    private val _onClickRegisterResult = SingleLiveEvent<Any>()
    val onClickRegisterResult: LiveData<Any> get() = _onClickRegisterResult


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

    fun addScoreDetail() {
        scoreDetailList.add(ScoreDetailItem())
    }

    fun addRecordDetail() {
        personalRecordList.add(PersonalRecordItem())
    }

    fun onClickRegisterResult() {
        _onClickRegisterResult.call()
    }

    fun registerResult() {
        val matchResultInfo = MatchResultInfo(
            1,
            1,
            this.matchReview.value,
            this.hostScore.value?.toInt(),
            this.guestScore.value?.toInt(),
            scoreDetailList.map { value ->
                ScoreDetailItemRequest(
                    value.hostScore.value?.toInt(),
                    value.guestScore.value?.toInt(),
                    MatchResultType.valueOf(value.matchResultType.get()!!).s
                )
            },
            personalRecordList.map { value ->
                PersonalRecordItemRequest(
                    value.score.value?.toInt(),
                    value.receiver.value,
                    MatchResultType.valueOf(value.matchResultType.get()!!).s
                )
            }
        )
        Log.i("TTT", "matchReInfo : " + matchResultInfo)
        matchResultInputUseCase.inputMatchResult(1, matchResultInfo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.i("TTT", "ok")
            }, {
                Log.e("TTT", "error! : " + it.message)
            })
            .addTo(compositeDisposable)
    }

}