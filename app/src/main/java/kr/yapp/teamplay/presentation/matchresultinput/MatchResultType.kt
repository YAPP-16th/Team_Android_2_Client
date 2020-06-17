package kr.yapp.teamplay.presentation.matchresultinput

enum class MatchResultType(var s: String) {
    스코어("SCORE"), 어시스트("ASSIST"), 리바운드("REBOUND"), `2점`("TWO_POINT"), 스틸("STEAL"),
    블록("BLOCK"), `3점`("THREE_POINT")
}
