package kr.yapp.teamplay.data

import io.reactivex.Single
import kr.yapp.teamplay.domain.repository.MainRepository

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
