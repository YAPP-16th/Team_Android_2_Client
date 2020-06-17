package kr.yapp.teamplay.domain.entity

data class AccessToken(
    val expireIn : Long,
    val token : String
)