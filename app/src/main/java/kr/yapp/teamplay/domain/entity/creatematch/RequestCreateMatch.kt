package kr.yapp.teamplay.domain.entity.creatematch

data class RequestCreateMatch(
    var requesterClubId: Int = 0,
    var createMatchDTO: RequestCreateMatchDto? = null
)
