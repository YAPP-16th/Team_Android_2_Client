package kr.yapp.teamplay.domain.usecase

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatch
import kr.yapp.teamplay.domain.repository.CreateMatchRepository

class CreateMatchUseCase(
    private val repository: CreateMatchRepository
) {
    fun requestCreateMatch(request: RequestCreateMatch?): Single<Any> =
        repository.createCreateMatch(request)
}