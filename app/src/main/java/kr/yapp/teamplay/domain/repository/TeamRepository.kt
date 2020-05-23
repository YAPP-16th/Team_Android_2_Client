package kr.yapp.teamplay.domain.repository

import io.reactivex.Single
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import kr.yapp.teamplay.domain.entity.TeamList

interface TeamRepository {

    fun getTeamMainItem(clubId: String): Single<TeamMainItemResponse>

    fun getAllClub(): Single<List<TeamList>>
}
