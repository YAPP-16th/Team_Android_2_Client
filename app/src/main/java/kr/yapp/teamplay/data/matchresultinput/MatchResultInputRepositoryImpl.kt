package kr.yapp.teamplay.data.matchresultinput

import io.reactivex.Single
import kr.yapp.teamplay.TeamPlayApplication
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.domain.entity.matchresultinput.MatchResultInfo
import kr.yapp.teamplay.domain.repository.MatchResultInputRepository
import kr.yapp.teamplay.util.PreferenceManager

class MatchResultInputRepositoryImpl(
    private val matchResultInputService: MatchResultInputService =
        RetrofitManager.getRetrofit().create(
            MatchResultInputService::class.java
        )
) : MatchResultInputRepository {
    override fun postMatchResult(
        matchId: Int,
        matchResultInfo: MatchResultInfo
    ): Single<Void> = matchResultInputService.matchResultInput(
        PreferenceManager.getTokenKey(TeamPlayApplication.appContext),
        matchId,
        matchResultInfo
    )
}