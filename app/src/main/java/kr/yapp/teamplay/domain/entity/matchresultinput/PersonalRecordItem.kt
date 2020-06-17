package kr.yapp.teamplay.domain.entity.matchresultinput

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

data class PersonalRecordItem(
    val score: MutableLiveData<String> = MutableLiveData("0"),
    val receiver: MutableLiveData<String> = MutableLiveData(""),
    val matchResultType: ObservableField<String> = ObservableField("리바운드")
)