package kr.yapp.teamplay.domain.usecase

import kr.yapp.teamplay.data.match.MatchRepositoryImpl
import kr.yapp.teamplay.domain.repository.MatchRepository

class GetMatchSearchList (
    private val repository : MatchRepository = MatchRepositoryImpl()
) {
    fun getMatchSearchList(startTimeFrom : String, startTimeTo : String
                     , location : String, matchStyle : String) =
        repository.getMatchList(
            null, startTimeFrom, startTimeTo, location, matchStyle
        )
}