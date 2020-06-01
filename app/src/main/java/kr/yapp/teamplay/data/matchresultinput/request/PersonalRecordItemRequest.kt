package kr.yapp.teamplay.data.matchresultinput.request

data class PersonalRecordItemRequest(
    val score: Int? = 0,
    val receiver: String? = "",
    val matchResultType: String? = "SCORE"
)