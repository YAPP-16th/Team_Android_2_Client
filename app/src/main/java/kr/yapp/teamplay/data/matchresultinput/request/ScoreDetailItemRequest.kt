package kr.yapp.teamplay.data.matchresultinput.request

data class ScoreDetailItemRequest(
    val hostScore: Int? = 0,
    val guestScore: Int? = 0,
    val matchResultType: String? = "SCORE"
)