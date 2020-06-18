/*
 * Created by Lee Oh Hyoung on 2020/06/14 .. 
 */
package kr.yapp.teamplay.data.match

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.domain.entity.matchresult.DetailedMatchResult
import kr.yapp.teamplay.domain.entity.matchresult.MatchResultScorePerType

data class MatchDetailedResultResponse(

    @SerializedName("matchDetailResult")
    val matchDetailResult: MatchDetailResponse
) {

    data class MatchDetailResponse(

        @SerializedName("guestName")
        val guestName: String,

        @SerializedName("hostName")
        val hostName: String,

        @SerializedName("matchDetailResultScore")
        val matchDetailResultScore: List<MatchDetailResultScore>
    )

    data class MatchDetailResultScore(

        @SerializedName("guestScore")
        val guestScore: Int,

        @SerializedName("hostScore")
        val hostScore: Int,

        @SerializedName("matchResultType")
        val matchResultType: String
    )
}

fun MatchDetailedResultResponse.MatchDetailResultScore.toEntity(): MatchResultScorePerType =
    MatchResultScorePerType(
        guestScore = guestScore,
        hostScore = hostScore,
        matchResultType = matchResultType
    )

fun MatchDetailedResultResponse.toEntity(): DetailedMatchResult =
    DetailedMatchResult(
        guestName = matchDetailResult.guestName,
        hostName = matchDetailResult.hostName,
        matchDetailResultScore = matchDetailResult.matchDetailResultScore.map { it.toEntity() }
    )
