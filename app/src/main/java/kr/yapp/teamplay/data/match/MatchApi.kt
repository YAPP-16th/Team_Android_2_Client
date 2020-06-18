package kr.yapp.teamplay.data.match

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.*

interface MatchApi {

    @GET("/v1/matches")
    fun getMatchList(
        @Query("all") all : Boolean?,
        @Query("descending") descending : Boolean?,
        @Query("location") location : String?,
        @Query("matchStyle") matchStyle : String?,
        @Query("page") page : Int?,
        @Query("rowsPerPage") rowsPerPage : Int?,
        @Query("sortBy") sortBy : String?,
        @Query("startTimeFrom") startTimeFrom : String?,
        @Query("startTimeTo") startTimeTo : String?
    ): Single<MatchListResponse>

    @GET("/v1/matches/{matchId}/result/detail")
    fun getDetailedMatchResult(
        @Path("matchId") matchId: Int
    ): Single<MatchDetailedResultResponse>

    @GET("/v1/matches/{matchId}/result/individual")
    fun getDetailedMatchIndividualResult(
        @Path("matchId") matchId: Int
    ): Single<MatchIndividualResultResponse>

    @POST("/v1/matches/{matchId}/matchRequest")
    fun requestMatch(
        @Header("accessToken") accessToken: String,
        @Body createMatchRequest: CreateMatchRequest,
        @Path("matchId") matchId: Int
    ): Completable

}
