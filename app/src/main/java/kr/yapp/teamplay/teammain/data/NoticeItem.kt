package kr.yapp.teamplay.teammain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NoticeItem(
    @SerializedName("title") val title: String = "",
    @SerializedName("createTime") val createTime: String = "",
    @SerializedName("content") val content: String = ""
) : Serializable
