package kr.yapp.teamplay.data

import io.reactivex.Single
import kr.yapp.teamplay.data.Comment
import retrofit2.http.GET

/**
 * Created by Lee Oh Hyoung on 2020/03/29.
 */
interface CommentService {

    @GET("/comments")
    fun getComments(): Single<List<Comment>>

}
