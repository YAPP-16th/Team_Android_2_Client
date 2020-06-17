package kr.yapp.teamplay.domain.entity.matchschedule

data class MatchScheduleOuterItem(
    val scheduleTitle: String,
    val matchScheduleInfo: List<MatchScheduleInnerItem>,
    val matchScheduleType: String
)