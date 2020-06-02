package kr.yapp.teamplay.domain.usecase

import kr.yapp.teamplay.domain.entity.matchresultinput.MatchResultInfo
import kr.yapp.teamplay.domain.repository.MatchResultInputRepository

class MatchResultInputUseCase(
    private val repository: MatchResultInputRepository
) {
    fun inputMatchResult(matchId: Int, matchResultInfo: MatchResultInfo) =
        repository.postMatchResult(matchId, matchResultInfo)

}