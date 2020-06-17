package kr.yapp.teamplay.data.creatematch

import io.reactivex.Single
import kr.yapp.teamplay.TeamPlayApplication
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatch
import kr.yapp.teamplay.domain.repository.CreateMatchRepository
import kr.yapp.teamplay.util.PreferenceManager

class CreateMatchRepositoryImpl(
    val service : CreateMatchService =
        RetrofitManager.create(CreateMatchService::class.java)
) : CreateMatchRepository {
    override fun createCreateMatch(request: RequestCreateMatch?): Single<Any> =
        service.createMatch(PreferenceManager.getTokenKey(TeamPlayApplication.appContext), request)
}