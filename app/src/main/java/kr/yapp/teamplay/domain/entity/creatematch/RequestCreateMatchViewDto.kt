package kr.yapp.teamplay.domain.entity.creatematch

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import kr.yapp.teamplay.data.match.MatchStyle
import java.text.SimpleDateFormat
import java.time.LocalTime
import java.util.*

data class RequestCreateMatchViewDto (
    val title: MutableLiveData<String> = MutableLiveData(),
    val matchMonth : MutableLiveData<String> = MutableLiveData((Calendar.getInstance().get(Calendar.MONTH) + 1).toString()),
    val matchDate : MutableLiveData<String> = MutableLiveData(Calendar.getInstance().get(Calendar.DAY_OF_MONTH).toString()),
    val startDate: MutableLiveData<String> = MutableLiveData(SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().time).toString()),
    val endDate: MutableLiveData<String> = MutableLiveData(SimpleDateFormat("hh:mm:ss").format(Calendar.getInstance().time).toString()),
    val locationA: MutableLiveData<String> = MutableLiveData(""),
    val locationB: MutableLiveData<String> = MutableLiveData(""),
    val locationC: MutableLiveData<String> = MutableLiveData(""),
    val locationD: MutableLiveData<String> = MutableLiveData(""),
    val matchStyle: MutableLiveData<String> = MutableLiveData("THREE_HALF_COURT"),
    val introduce: MutableLiveData<String> = MutableLiveData("")
)