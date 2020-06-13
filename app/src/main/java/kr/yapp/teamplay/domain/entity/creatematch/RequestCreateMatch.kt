package kr.yapp.teamplay.domain.entity.creatematch

data class RequestCreateMatch(
    var requesterUserId: Int = 0,
    var requesterClubId: Int = 0,
    var createMatchDto: RequestCreateMatchDto? = null
)
