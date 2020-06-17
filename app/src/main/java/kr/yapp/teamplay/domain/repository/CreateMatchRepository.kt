package kr.yapp.teamplay.domain.repository

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatch

interface CreateMatchRepository {
    fun createCreateMatch(request: RequestCreateMatch?) : Single<Any>
}