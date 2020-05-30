package kr.yapp.teamplay.data.post.response

data class PostResponse(
    val type: String = "공지사항",
    val title: String = "공지사항입니다.",
    val content: String = "게시글입니다."
)