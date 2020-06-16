package kr.yapp.teamplay.presentation.match_schedule

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.matchschedule.MatchScheduleRepositoryImpl
import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleOuterItem
import kr.yapp.teamplay.domain.usecase.MatchScheduleUseCase
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class MatchScheduleViewModel(
    private val matchScheduleUseCase: MatchScheduleUseCase =
        MatchScheduleUseCase(MatchScheduleRepositoryImpl())
) : ViewModel() {

    companion object {
        private const val TAG: String = "MatchSchedule"
    }

    private val _matchScheduleItem = MutableLiveData<List<MatchScheduleOuterItem>>()
    val matchScheduleItem: LiveData<List<MatchScheduleOuterItem>> get() = _matchScheduleItem

    private val _startMatchResultInput = MutableLiveData<Int>()
    val startMatchResultInput : LiveData<Int> get() = _startMatchResultInput

    private val compositeDisposable: CompositeDisposable =
        CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchScheduleItem(clubId: String): Disposable {
        return matchScheduleUseCase.getOuterItem(clubId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ item ->
                _matchScheduleItem.value = item
                Log.e(TAG, "get : ${item}")
            }, {
                Log.e(TAG, "error: ${it.message}")
            })
            .addTo(compositeDisposable)
    }

    fun acceptMatch(matchId: String, context : Context) {
        matchScheduleUseCase.acceptMatch(matchId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.i("TTT", "ok")
                (context as MatchScheduleActivity).finish()
            }, {
                Log.e("TTT", "error! : " + it.message)
                (context as MatchScheduleActivity).finish()
                Toast.makeText(context, "매치를 수락했습니다.", Toast.LENGTH_LONG).show()
            })
            .addTo(compositeDisposable)
    }

    fun declineMatch(matchId: String, context : Context) {
        matchScheduleUseCase.declineMatch(matchId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.i("TTT", "ok")
                (context as MatchScheduleActivity).finish()
            }, {
                Log.e("TTT", "error! : " + it.message)
                (context as MatchScheduleActivity).finish()
                Toast.makeText(context, "매치를 거절했습니다.", Toast.LENGTH_LONG).show()
            })
            .addTo(compositeDisposable)
    }

    fun startMatchResultInput(matchId: Int) {
        _startMatchResultInput.value = matchId
    }

}