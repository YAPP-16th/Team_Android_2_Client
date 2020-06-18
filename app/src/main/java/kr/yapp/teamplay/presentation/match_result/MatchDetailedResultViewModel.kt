/*
 * Created by Lee Oh Hyoung on 2020/06/14 .. 
 */
package kr.yapp.teamplay.presentation.match_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.match.MatchRepositoryImpl
import kr.yapp.teamplay.domain.repository.MatchRepository
import kr.yapp.teamplay.presentation.BaseViewModel

class MatchDetailedResultViewModel(
    private val matchRepository: MatchRepository =
        MatchRepositoryImpl()
) : BaseViewModel() {

    private val _uiState = MutableLiveData<MatchDetailedResultUiState>()
    val uiState: LiveData<MatchDetailedResultUiState> get() = _uiState

    fun getMatchResult(matchId: Int) {
        matchRepository.getDetailedMatchResult(matchId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { result ->
                MatchDetailedResultUiState.Result(
                    message = "경기 결과를 정상적으로 가져왔습니다",
                    hostName = result.hostName,
                    guestName = result.guestName,
                    resultScores = result.matchDetailResultScore
                )
            }
            .subscribe({ result ->
                _uiState.value = result
            }, { throwable ->
                Logger.d("경기 결과를 가져오지 못하였습니다")
                _uiState.value = MatchDetailedResultUiState.Error(
                    message = "경기 결과를 가져오지 못하였습니다",
                    throwable = throwable
                )
            })
            .addDisposable()
    }

    fun getIndividualResult(matchId: Int) {
        matchRepository.getDetailedMatchIndividualResult(matchId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { list ->
                MatchDetailedResultUiState.Individual(
                    message = "개인기록을 정상적으로 가져왔습니다",
                    individualScore = list
                )
            }
            .subscribe({ individual ->
                _uiState.value = individual
            }, { throwable ->
                Logger.d("개인기록을 가져오지 못하였습니다")
                _uiState.value = MatchDetailedResultUiState.Error(
                    message = "개인기록을 가져오지 못하였습니다",
                    throwable = throwable
                )
            })
            .addDisposable()
    }

}
