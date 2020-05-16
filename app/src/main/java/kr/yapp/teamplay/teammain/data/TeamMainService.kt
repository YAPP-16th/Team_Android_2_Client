package kr.yapp.teamplay.teammain.data

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamMainService {

    @GET("https://api.fonnie.shop/clubs/{clubId}")
    fun getTeamMainInfo(@Path("clubId") clubId: String): Single<TeamMainItem>

}