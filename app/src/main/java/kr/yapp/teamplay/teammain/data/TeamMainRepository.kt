package kr.yapp.teamplay.teammain.data

import io.reactivex.Single

interface TeamMainRepository {
    fun getTeamMainItem(): Single<TeamMainItem>
}