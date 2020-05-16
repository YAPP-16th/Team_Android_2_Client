package kr.yapp.teamplay.teammain.data

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.teammain.data.dto.SimpleClubInfo
import java.io.Serializable

/**
 * @author ohjuntaek
 * @since 2020. 04. 17 Mon
 *
 * team_main 화면 데이터 임시 정의
 *
 * TODO : API 정의 후 업데이트
 * TODO : 동호회 게시판(Feed) 추가
 */
data class TeamMainItem(
    @SerializedName("simpleClubInfo") val simpleClubInfo: SimpleClubInfo,
    @SerializedName("feedCount") val feedCount: String,
    @SerializedName("simpleFeeds") val feedItems: List<TeamMainFeedItem>
) : Serializable