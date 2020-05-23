package kr.yapp.teamplay.data.teammain.response

import kr.yapp.teamplay.data.search.TeamList

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
data class TeamListResponse(
    val count: Int,
    val list: List<TeamList>
)
