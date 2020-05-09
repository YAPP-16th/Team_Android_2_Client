package kr.yapp.teamplay.teammain.data

import com.google.gson.annotations.SerializedName

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
    @SerializedName("tag") val tag: String,
    @SerializedName("name") val name: String,
    @SerializedName("address") val address: String,
    @SerializedName("create_date") val createDate: String,
    @SerializedName("member_count") val memberCount: String,
    @SerializedName("feed_count") val feedCount: String,
    @SerializedName("feed_items") val feedItems: List<TeamMainFeedItem>
)