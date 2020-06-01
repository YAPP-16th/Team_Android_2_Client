package kr.yapp.teamplay.domain.entity

import java.io.Serializable

data class Search (
    var startTime : String = "",
    var endTime : String = "",
    var location : String = "",
    val matchRule : String = ""
) : Serializable