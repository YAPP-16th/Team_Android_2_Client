package kr.yapp.teamplay.domain.usecase

import io.reactivex.Completable
import io.reactivex.Single
import kr.yapp.teamplay.data.match.CreateMatchRequest
import kr.yapp.teamplay.data.match.MatchRepositoryImpl
import kr.yapp.teamplay.domain.repository.MatchRepository

class PostMatchRequest(
    private val repository : MatchRepository = MatchRepositoryImpl()
) {
    fun requestMatch(createMatchRequest: CreateMatchRequest, matchId: Int): Completable
            = repository.requestMatch(createMatchRequest, matchId)
}