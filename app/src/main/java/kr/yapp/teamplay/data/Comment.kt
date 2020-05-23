package kr.yapp.teamplay.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Lee Oh Hyoung on 2020/03/29.
 */
@Deprecated("연습용으로 사용")
data class Comment (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("body") val body: String
) : Serializable
