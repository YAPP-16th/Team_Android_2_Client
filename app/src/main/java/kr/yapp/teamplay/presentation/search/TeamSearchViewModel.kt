package kr.yapp.teamplay.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.teammain.TeamRepositoryImpl
import kr.yapp.teamplay.domain.entity.TeamList
import kr.yapp.teamplay.domain.repository.TeamRepository
import kr.yapp.teamplay.presentation.BaseViewModel

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
class TeamSearchViewModel(
    private val teamRepository: TeamRepository =
        TeamRepositoryImpl()
) : BaseViewModel() {

    private val _teams = MutableLiveData<List<TeamList>>()
    val teams: LiveData<List<TeamList>> get() = _teams

    fun getAllClub() {
        teamRepository.getAllClub()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object: SingleObserver<List<TeamList>> {
                override fun onSuccess(list: List<TeamList>) {
                    _teams.value = list
                }

                override fun onSubscribe(d: Disposable) {
                    /* explicitly empty */
                }

                override fun onError(e: Throwable) {
                    showError(e.message.toString())
                }

            })
    }

}
