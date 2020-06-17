package kr.yapp.teamplay.data.post

import io.reactivex.Single
import kr.yapp.teamplay.domain.entity.post.Post
import kr.yapp.teamplay.domain.repository.PostRepository

class PostRepositoryImpl(
    private val postService: PostService = PostService()
) : PostRepository {
    override fun getPostInfo(postId: String): Single<Post> {
        return Single.just(
            postService.getPost(postId)
        )
    }

    override fun setPostInfo(postId: String, post: Post) {
        postService.setPost(postId, post)
    }

}