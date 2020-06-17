package kr.yapp.teamplay.presentation.editpost

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.post.PostRepositoryImpl
import kr.yapp.teamplay.domain.entity.post.Post
import kr.yapp.teamplay.domain.usecase.PostUseCase
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class EditPostViewModel(
    private val useCase: PostUseCase =
        PostUseCase(PostRepositoryImpl())
) : ViewModel() {

    companion object {
        private const val TAG = "EditPostViewModel"
    }

    private val compositeDisposable = CompositeDisposable()

    private val _post = MutableLiveData<Post>()
    val post: LiveData<Post> get() = _post

    val content = MutableLiveData<String>()
    val title = MutableLiveData<String>()
    val type = MutableLiveData<String>()

    val onWriteClick: SingleLiveEvent<Void> = SingleLiveEvent()

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun fetchPost(toast: (message: String?) -> Unit = {}) {
        useCase.getPostInfo("1")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ item ->
                _post.value = item
                type.value = item.type
                title.value = item.title
                content.value = item.content
            }, {
                Log.e(TAG, "error: ${it.message}")
                toast(it.message)
            })
            .addTo(compositeDisposable)
    }

    fun writePost() {
        onWriteClick.call()
    }

    fun setPost(toast: (message: String?) -> Unit = {}) {
        useCase.setPostInfo("1", Post(type.value, title.value, content.value))
        toast("ok")
    }
}