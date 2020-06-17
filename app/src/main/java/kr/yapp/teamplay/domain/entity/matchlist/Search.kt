package kr.yapp.teamplay.domain.entity.matchlist

import java.io.Serializable

data class Search (
    var startTime : String = "",
    var endTime : String = "",
    var location : String = "",
    var matchRule : String = ""
) : Serializable