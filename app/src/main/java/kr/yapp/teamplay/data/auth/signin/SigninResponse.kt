package kr.yapp.teamplay.data.auth.signin

import com.google.gson.annotations.SerializedName
import kr.yapp.teamplay.domain.entity.AccessToken
import kr.yapp.teamplay.domain.entity.matchlist.UserInfo

data class SigninResponse (
    @SerializedName("accessToken") val accessToken : AccessToken,
    @SerializedName("message") val message : String,
    @SerializedName("refreshToken") val refreshToken : String,
    @SerializedName("userInfo") val userInfo: UserInfo
)
