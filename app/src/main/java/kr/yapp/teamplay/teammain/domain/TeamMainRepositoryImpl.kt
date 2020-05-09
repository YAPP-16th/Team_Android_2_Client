package kr.yapp.teamplay.teammain.domain

import io.reactivex.Single
import kr.yapp.teamplay.teammain.data.*

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
                "52",
                "112 post",
                arrayListOf(
                    TeamMainFeedItem("0", ResultItem(), null),
                    TeamMainFeedItem("0", ResultItem(), null),
                    TeamMainFeedItem("1", null, NoticeItem()),
                    TeamMainFeedItem("0", ResultItem(isWin = false), null),
                    TeamMainFeedItem("1", null, NoticeItem())
                )
            )
        )
    }
}