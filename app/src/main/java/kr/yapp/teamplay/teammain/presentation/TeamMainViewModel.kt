package kr.yapp.teamplay.teammain.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.teammain.data.TeamMainItem
import kr.yapp.teamplay.teammain.data.TeamMainRepository
import kr.yapp.teamplay.teammain.domain.TeamMainRepositoryImpl

class TeamMainViewModel(
    private val teamMainRepository: TeamMainRepository =
        TeamMainRepositoryImpl()
) : ViewModel() {

    companion object {
        private const val TAG: String = "TeamMainViewModel"
    }

    private val compositeDisposable: CompositeDisposable =
        CompositeDisposable()

    private val _teamMainItem = MutableLiveData<TeamMainItem>()
    val teamMainItem: LiveData<TeamMainItem> get() = _teamMainItem

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchTeamMainItem(): Disposable {
        return teamMainRepository.getTeamMainItem()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ item ->
                _teamMainItem.value = item
            }, {
                Log.d(TAG, "error: ${it.message}")
            })
            .addTo(compositeDisposable)
    }
}