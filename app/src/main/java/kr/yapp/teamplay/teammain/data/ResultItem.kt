package kr.yapp.teamplay.teammain.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResultItem(
    @SerializedName("createTime") val createTime: String = "",
    @SerializedName("teamName") val teamName: String = "",
    @SerializedName("isWin") val isWin: Boolean
) : Serializable
