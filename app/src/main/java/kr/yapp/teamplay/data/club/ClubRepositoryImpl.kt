/*
 * Created by Lee Oh Hyoung on 2020/05/30 .. 
 */
package kr.yapp.teamplay.data.club

import io.reactivex.Single
import kr.yapp.teamplay.data.RetrofitManager
import kr.yapp.teamplay.domain.entity.TeamCharacter
import kr.yapp.teamplay.domain.repository.ClubRepository

class ClubRepositoryImpl(
    private val clubApi: ClubApi =
        RetrofitManager.create(ClubApi::class.java)
) : ClubRepository {

    override fun getTeamCharacters(): Single<List<TeamCharacter>> =
        clubApi.getTeamCharacters()
            .map { response -> response.toEntity() }
}
