package kr.yapp.teamplay.domain.usecase

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.post.Post
import kr.yapp.teamplay.domain.repository.PostRepository

class PostUseCase(
    private val postRepository: PostRepository
) {
    fun getPostInfo(postId: String): Single<Post> = postRepository.getPostInfo(postId)

    fun setPostInfo(postId: String, post: Post) {
        postRepository.setPostInfo(postId, post)
    }
}
