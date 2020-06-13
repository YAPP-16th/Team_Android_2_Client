package kr.yapp.teamplay.domain.entity.creatematch

import kr.yapp.teamplay.data.match.MatchStyle

data class RequestCreateMatchDto(
    val title: String? = "",
    val startDate: String? = "",
    val endDate: String? = "",
    val location: String? = "",
    val matchStyle: String? = MatchStyle.THREE_HALF_COURT.toString(),
    val introduce: String? = ""
)
