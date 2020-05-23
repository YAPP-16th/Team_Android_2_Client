package kr.yapp.teamplay.data.teammain

import io.reactivex.Single
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.data.search.toEntity
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import kr.yapp.teamplay.domain.entity.TeamList
import kr.yapp.teamplay.domain.repository.TeamRepository

class TeamRepositoryImpl(
    private val teamService: TeamService =
        RetrofitManager.getRetrofit().create(
            TeamService::class.java
        )
) : TeamRepository {

    override fun getTeamMainItem(clubId: String): Single<TeamMainItemResponse> {
        return teamService.getTeamMainInfo(clubId)
    }

    override fun getAllClub(): Single<List<TeamList>> {
        return teamService.getAllClub().map { response ->
            response.list.map { it.toEntity() }
        }
    }
}
