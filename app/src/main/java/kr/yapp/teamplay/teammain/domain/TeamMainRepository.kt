package kr.yapp.teamplay.teammain.domain

import io.reactivex.Single
import kr.yapp.teamplay.teammain.data.TeamMainItem

interface TeamMainRepository {
    fun getTeamMainItem(clubId: String): Single<TeamMainItem>
}