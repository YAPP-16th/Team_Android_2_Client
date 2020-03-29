package kr.yapp.teamplay.domain

import io.reactivex.Single
import kr.yapp.teamplay.data.Comment
import kr.yapp.teamplay.data.CommentService
import kr.yapp.teamplay.data.MainRepository
import kr.yapp.teamplay.data.RetrofitManager

/**
 * Created by Lee Oh Hyoung on 2020/03/29.
 */
class MainRepositoryImpl(
    private val commentService: CommentService =
        RetrofitManager.getRetrofit().create(CommentService::class.java)
) : MainRepository {

    override fun getComments(): Single<List<Comment>> =
        commentService.getComments()
}
