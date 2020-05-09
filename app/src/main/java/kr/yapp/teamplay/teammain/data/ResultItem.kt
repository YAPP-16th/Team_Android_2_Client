package kr.yapp.teamplay.teammain.data

import java.io.Serializable

data class ResultItem(
    val createTime: String = "2020.3.9. 16:00",
    val teamName: String = "남양주 팀 열정",
    val isWin: Boolean = true
) : Serializable
