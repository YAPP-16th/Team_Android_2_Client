package kr.yapp.teamplay.domain.usecase

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleOuterItem
import kr.yapp.teamplay.domain.repository.MatchScheduleRepository

class MatchScheduleUseCase(
    private val repository: MatchScheduleRepository
) {
    fun getOuterItem(clubId: String): Single<List<MatchScheduleOuterItem>> =
        repository.getMatchScheduleItem(clubId)
}
