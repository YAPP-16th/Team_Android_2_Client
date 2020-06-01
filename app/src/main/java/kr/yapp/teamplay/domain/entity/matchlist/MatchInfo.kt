package kr.yapp.teamplay.domain.entity.matchlist

import java.io.Serializable

data class MatchInfo(
    val hostName: String,
    val id : Long,
    val introduce: String,
    val location: String,
    val matchDate: String,
    val matchRule : String,
    val matchStyle: String,
    val matchTime: String,
    val title: String
) : Serializable