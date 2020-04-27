package kr.yapp.teamplay.teammain.domain

import io.reactivex.Single
import kr.yapp.teamplay.teammain.data.TeamMainItem
import kr.yapp.teamplay.teammain.data.TeamMainRepository

class TeamMainRepositoryImpl(
    private val TeamMainService: Any = ""
) : TeamMainRepository {
    override fun getTeamMainItem(): Single<TeamMainItem> {
        return Single.just(
            TeamMainItem(
                "상암동대표",
                "상암동 농구클럽",
                "서울시 마포구 상암동 소재",
                "2017.02.11",
                "52"
            )
        )
    }
}