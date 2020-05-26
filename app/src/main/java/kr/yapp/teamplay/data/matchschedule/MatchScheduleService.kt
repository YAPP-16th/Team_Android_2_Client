package kr.yapp.teamplay.data.matchschedule

import io.reactivex.Single
import kr.yapp.teamplay.data.matchschedule.response.MatchScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface MatchScheduleService {
    @GET("https://api.fonnie.xyz/v1/matches/schedule/{clubId}")
    fun getOuterItem(@Path("clubId") clubId: String): Single<MatchScheduleResponse>
}