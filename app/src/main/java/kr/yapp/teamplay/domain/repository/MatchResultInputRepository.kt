package kr.yapp.teamplay.domain.repository

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.matchresultinput.MatchResultInfo

interface MatchResultInputRepository {
    fun postMatchResult(matchId: Int, matchResultInfo: MatchResultInfo): Single<Void>
}