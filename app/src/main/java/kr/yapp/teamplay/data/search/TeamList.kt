package kr.yapp.teamplay.data.search

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.domain.entity.TeamList as Entity

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
data class TeamList(
    @SerializedName("clubId")
    val clubId: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("address")
    val address: String,
    @SerializedName("current_count")
    val currentCount: Int = 0
)

fun TeamList.toEntity() = Entity(
    title = title,
    address = address,
    currentCount = currentCount
)
