package kr.yapp.teamplay.data.teammain

import io.reactivex.Single
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import kr.yapp.teamplay.domain.repository.TeamMainRepository

class TeamMainRepositoryImpl(
    private val teamMainService: TeamMainService =
        RetrofitManager.getRetrofit().create(
            TeamMainService::class.java
        )
) : TeamMainRepository {
    override fun getTeamMainItem(clubId: String): Single<TeamMainItemResponse> {
        return teamMainService.getTeamMainInfo(clubId)
    }
}