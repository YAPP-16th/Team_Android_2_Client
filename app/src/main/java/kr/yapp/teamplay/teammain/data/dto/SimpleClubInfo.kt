package kr.yapp.teamplay.teammain.data.dto

import com.google.gson.annotations.SerializedName

data class SimpleClubInfo(
    @SerializedName("tag") val tag: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("location") val location: String = "",
    @SerializedName("createDate") val createDate: String = "",
    @SerializedName("memberCount") val memberCount: String = ""
)