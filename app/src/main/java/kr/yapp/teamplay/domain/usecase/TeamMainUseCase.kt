package kr.yapp.teamplay.domain.usecase

import io.reactivex.Single
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import kr.yapp.teamplay.domain.repository.TeamMainRepository

class TeamMainUseCase(
    private val repository: TeamMainRepository
) {
    fun setClubInfo(clubId: String): Single<TeamMainItemResponse> =
        repository.getTeamMainItem(clubId)
}