package kr.yapp.teamplay.data.matchschedule

import io.reactivex.Single
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleOuterItem
import kr.yapp.teamplay.domain.repository.MatchScheduleRepository

class MatchScheduleRepositoryImpl(
    private val matchScheduleService: MatchScheduleService =
        RetrofitManager.getRetrofit().create(
            MatchScheduleService::class.java
        )
) : MatchScheduleRepository {
    override fun getMatchScheduleItem(clubId: String): Single<List<MatchScheduleOuterItem>> {
        return matchScheduleService.getOuterItem(clubId)
            .map { response ->
                response.matchSchedule.map {
                    MatchScheduleOuterItem(
                        it.scheduleTitle,
                        it.matchScheduleInfo,
                        it.matchScheduleType
                    )
                }
            }
    }

}
