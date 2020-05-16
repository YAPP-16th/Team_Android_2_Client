package kr.yapp.teamplay.teammain.data

import io.reactivex.Single
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.teammain.domain.TeamMainRepository

class TeamMainRepositoryImpl(
    private val teamMainService: TeamMainService =
        RetrofitManager.getRetrofit().create(
            TeamMainService::class.java
        )
) : TeamMainRepository {
    override fun getTeamMainItem(clubId: String): Single<TeamMainItem> {
        return teamMainService.getTeamMainInfo(clubId)
    }
}