/*
 * Created by Lee Oh Hyoung on 2020/06/14 .. 
 */
package kr.yapp.teamplay.data.match

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.domain.entity.matchresult.MatchIndividualScore

data class MatchIndividualResultResponse(

    @SerializedName("matchIndividualResult")
    val individualResult: List<IndividualResponse>
) {
    data class IndividualResponse(

        @SerializedName("matchResultType")
        val matchResultType: String,

        @SerializedName("recevier")
        val receiver: String,

        @SerializedName("score")
        val score: Int
    )
}

fun MatchIndividualResultResponse.toEntity(): List<MatchIndividualScore> =
    individualResult.map {
        MatchIndividualScore(
            matchResultType = it.matchResultType,
            receiver = it.receiver,
            score = it.score
        )
    }
