package kr.yapp.teamplay.domain.entity.matchresultinput

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

data class ScoreDetailItem(
    val hostScore: MutableLiveData<String> = MutableLiveData("0"),
    val guestScore: MutableLiveData<String> = MutableLiveData("0"),
    var matchResultType: ObservableField<String> = ObservableField("리바운드")
)