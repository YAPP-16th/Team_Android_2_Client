package kr.yapp.teamplay.data.teammain

import io.reactivex.Single
import kr.yapp.teamplay.data.teammain.response.TeamListResponse
import kr.yapp.teamplay.data.teammain.response.TeamMainItemResponse
import kr.yapp.teamplay.domain.entity.TeamList
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamService {

    @GET("/clubs/{clubId}")
    fun getTeamMainInfo(@Path("clubId") clubId: String): Single<TeamMainItemResponse>

    @GET("/clubs")
    fun getAllClub(): Single<TeamListResponse>

}
