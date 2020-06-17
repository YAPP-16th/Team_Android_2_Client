package kr.yapp.teamplay.presentation.creatematch

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.TeamPlayApplication
import kr.yapp.teamplay.data.creatematch.CreateMatchRepositoryImpl
import kr.yapp.teamplay.data.match.MatchStyle
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatch
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatchDto
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatchViewDto
import kr.yapp.teamplay.domain.usecase.CreateMatchUseCase
import kr.yapp.teamplay.presentation.util.SingleLiveEvent
import kr.yapp.teamplay.util.PreferenceManager
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.*

class CreateMatchViewModel(
    private val useCase: CreateMatchUseCase =
        CreateMatchUseCase(CreateMatchRepositoryImpl())
) : ViewModel() {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    val requestCreateMatchViewDto = RequestCreateMatchViewDto()
    private val _click = SingleLiveEvent<Any>()
    val click : LiveData<Any> get() = _click

    private val _isCreated = SingleLiveEvent<Any>()
    val isCreated : LiveData<Any> get() = _isCreated

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }


    @RequiresApi(Build.VERSION_CODES.O)
    fun requestCreateMatch() {
        _click.call()
        val startDate = LocalDateTime.of(
            LocalDate.of(
                GregorianCalendar().get(Calendar.YEAR),
                requestCreateMatchViewDto.matchMonth.value!!.toInt(),
                requestCreateMatchViewDto.matchDate.value!!.toInt()
            ),
            LocalTime.parse(
                requestCreateMatchViewDto.startDate.value
            )
        )

        val endDate = LocalDateTime.of(
            LocalDate.of(
                GregorianCalendar().get(Calendar.YEAR),
                requestCreateMatchViewDto.matchMonth.value!!.toInt(),
                requestCreateMatchViewDto.matchDate.value!!.toInt()
            ),
            LocalTime.parse(
                requestCreateMatchViewDto.endDate.value
            )
        )

        val location = "${requestCreateMatchViewDto.locationA.value} " +
                "${requestCreateMatchViewDto.locationB.value} " +
                "${requestCreateMatchViewDto.locationC.value} " +
                "${requestCreateMatchViewDto.locationD.value} "

        val map  = mutableMapOf(
            Pair("3대3 반코트", "THREE_HALF_COURT"),
            Pair("5대5 반코트", "FIVE_HALF_COURT"),
            Pair("5대5 풀코트", "FIVE_FULL_COURT")
        )


        val requestMatchInfo = RequestCreateMatch()
        requestMatchInfo.requesterClubId = PreferenceManager.getSelectedTeamId(TeamPlayApplication.appContext)
        requestMatchInfo.createMatchDTO =
            RequestCreateMatchDto(
                requestCreateMatchViewDto.title.value,
                startDate.toString(),
                endDate.toString(),
                location,
                map[requestCreateMatchViewDto.matchStyle.value],
                requestCreateMatchViewDto.introduce.value
            )

        useCase.requestCreateMatch(requestMatchInfo)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.i("TTT", "ok")
                _isCreated.call()

            }, {
                Log.e("TTT", "error! : " + it.message)
                _isCreated.call()
            })
            .addTo(compositeDisposable)
    }

}