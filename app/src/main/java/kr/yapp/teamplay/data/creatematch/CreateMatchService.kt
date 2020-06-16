package kr.yapp.teamplay.data.creatematch

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.creatematch.RequestCreateMatch
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface CreateMatchService {

    @POST("/v1/matches")
    fun createMatch(@Header("accessToken") accessToken: String, @Body body : RequestCreateMatch?) : Single<Any>

}
