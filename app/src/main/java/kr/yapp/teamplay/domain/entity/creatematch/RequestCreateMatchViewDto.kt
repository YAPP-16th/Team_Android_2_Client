package kr.yapp.teamplay.domain.entity.creatematch

import androidx.lifecycle.MutableLiveData
import kr.yapp.teamplay.data.match.MatchStyle

data class RequestCreateMatchViewDto(
    val title: MutableLiveData<String> = MutableLiveData(),
    val matchMonth : MutableLiveData<String> = MutableLiveData(),
    val matchDate : MutableLiveData<String> = MutableLiveData(),
    val startDate: MutableLiveData<String> = MutableLiveData(),
    val endDate: MutableLiveData<String> = MutableLiveData(),
    val locationA: MutableLiveData<String> = MutableLiveData(),
    val locationB: MutableLiveData<String> = MutableLiveData(),
    val locationC: MutableLiveData<String> = MutableLiveData(),
    val locationD: MutableLiveData<String> = MutableLiveData(),
    val matchStyle: MutableLiveData<String> = MutableLiveData("THREE_HALF_COURT"),
    val introduce: MutableLiveData<String> = MutableLiveData()
)