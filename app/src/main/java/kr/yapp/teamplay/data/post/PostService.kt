package kr.yapp.teamplay.data.post

import android.util.Log
import kr.yapp.teamplay.domain.entity.post.Post

val map = mutableMapOf(Pair("1", Post("공지사항", "공지사항입니다.", "게시글입니다.")))

class PostService {

    fun getPost(postId: String): Post? {
        return map.get(postId)
    }

    fun setPost(postId: String, post: Post) {
        map[postId] = post
        Log.i("TTT", "content: " + map[postId]?.content)
    }

}
