package kr.yapp.teamplay.data.match

data class MatchListResponse(
    val currentPage: Int,
    val filterTitle : String,
    val matchList: MutableList<MatchList>,
    val totalPage: Int
)