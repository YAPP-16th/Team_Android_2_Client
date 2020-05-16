package kr.yapp.teamplay.domain.repository

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.post.Post

interface PostRepository {
    fun getPostInfo(postId: String): Single<Post>

    fun setPostInfo(postId: String, post: Post)
}
