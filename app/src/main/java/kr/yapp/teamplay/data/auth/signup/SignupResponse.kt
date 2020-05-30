package kr.yapp.teamplay.data.auth.signup

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.domain.entity.AccessToken
import kr.yapp.teamplay.domain.entity.UserInfo

data class SignupResponse (
    @SerializedName("accessToken") val accessToken : AccessToken,
    @SerializedName("message") val message : String,
    @SerializedName("refreshToken") val refreshToken : String,
    @SerializedName("userInfo") val userInfo : UserInfo
)
