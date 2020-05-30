package kr.yapp.teamplay.data.matchschedule.response

import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleOuterItem

data class MatchScheduleResponse(
    val matchSchedule: List<MatchScheduleOuterItem>
)