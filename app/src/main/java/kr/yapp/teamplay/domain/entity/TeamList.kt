package kr.yapp.teamplay.domain.entity

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
data class TeamList(
    val clubId: Int = 0,
    val title: String = "",
    val address: String,
    val currentCount: Int = 0
)
