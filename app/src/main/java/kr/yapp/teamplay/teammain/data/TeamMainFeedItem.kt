package kr.yapp.teamplay.teammain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamMainFeedItem(
    @SerializedName("type") val type: String,
    @SerializedName("simpleResultInfo") val resultItem: ResultItem?,
    @SerializedName("simpleNoticeInfo") val noticeItem: NoticeItem?
) : Serializable
