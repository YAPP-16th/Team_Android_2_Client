package kr.yapp.teamplay.domain.repository

import io.reactivex.Single
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse

interface TeamMainRepository {
    fun getTeamMainItem(clubId: String): Single<TeamMainItemResponse>
}