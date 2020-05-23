package kr.yapp.teamplay.domain.entity.teammain

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResultItem(
    val createTime: String = "",
    val teamName: String = "",
    @SerializedName("win") val isWin: Boolean
) : Serializable
