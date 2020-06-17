package kr.yapp.teamplay.domain.entity.matchresultinput

import kr.yapp.teamplay.data.matchresultinput.request.PersonalRecordItemRequest
import kr.yapp.teamplay.data.matchresultinput.request.ScoreDetailItemRequest

data class MatchResultInfo(
    val requesterClubId: Int,
    val matchReview: String? = "",
    val hostScore: Int? = 0,
    val guestScore: Int? = 0,
    val detailResult: List<ScoreDetailItemRequest>,
    val individualResult: List<PersonalRecordItemRequest>
)