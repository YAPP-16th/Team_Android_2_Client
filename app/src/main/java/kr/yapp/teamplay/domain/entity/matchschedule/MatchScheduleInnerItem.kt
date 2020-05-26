package kr.yapp.teamplay.domain.entity.matchschedule

data class MatchScheduleInnerItem(
    val title: String?,
    val description: String?,
    val matchDate: String?,
    val matchTime: String?,
    val requestStatus: String?,
    val matchRequestId: Int?
)