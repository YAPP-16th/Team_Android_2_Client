package kr.yapp.teamplay.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.Comment
import kr.yapp.teamplay.data.MainRepository
import kr.yapp.teamplay.domain.MainRepositoryImpl

/**
 * Created by Lee Oh Hyoung on 2020/03/28.
 */
class MainViewModel(
    private val mainRepository: MainRepository =
        MainRepositoryImpl()
) : ViewModel() {

    companion object {
        private const val TAG: String = "MAinViewModel"
    }

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> get() = _comments

    private val compositeDisposable: CompositeDisposable =
        CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun getComments() {
        mainRepository.getComments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list->
                _comments.value = list
            }, {
                Log.d(TAG, "error: ${it.message}")
            })
            .addTo(compositeDisposable)
    }

}
