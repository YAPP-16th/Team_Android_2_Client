package kr.yapp.teamplay.data.teammain

import io.reactivex.Single
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamMainService {

    @GET("/clubs/{clubId}")
    fun getTeamMainInfo(@Path("clubId") clubId: String): Single<TeamMainItemResponse>

}