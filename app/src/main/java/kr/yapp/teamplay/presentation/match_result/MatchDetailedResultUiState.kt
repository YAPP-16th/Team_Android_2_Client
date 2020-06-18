/*
 * Created by Lee Oh Hyoung on 2020/06/14 .. 
 */
package kr.yapp.teamplay.presentation.match_result

import kr.yapp.teamplay.domain.entity.matchresult.MatchIndividualScore
import kr.yapp.teamplay.domain.entity.matchresult.MatchResultScorePerType

sealed class MatchDetailedResultUiState {

    abstract val message: String

    data class Result(
        override val message: String,
        val guestName: String,
        val hostName: String,
        val resultScores: List<MatchResultScorePerType>
    ): MatchDetailedResultUiState()

    data class Individual(
        override val message: String,
        val individualScore: List<MatchIndividualScore>
    ): MatchDetailedResultUiState()

    data class Error(
        override val message: String,
        val throwable: Throwable
    ): MatchDetailedResultUiState()
}
