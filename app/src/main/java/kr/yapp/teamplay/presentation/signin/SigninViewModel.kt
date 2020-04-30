package kr.yapp.teamplay.presentation.signin

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.data.Comment
import kr.yapp.teamplay.data.MainRepository
import kr.yapp.teamplay.domain.MainRepositoryImpl
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class SigninViewModel(private val mainRepository: MainRepository =
                          MainRepositoryImpl()
) : ViewModel(){

    val clickSigninEmailCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickSigninPasswordCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    var doSigninCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    var doSignupCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    var doSigninFinishCallback : SingleLiveEvent<Void> = SingleLiveEvent()

    fun clickSigninEmailButton(view : View) {
        clickSigninEmailCallback.call()
    }

    fun clickSigninPasswordButton(view : View) {
        clickSigninPasswordCallback.call()
    }

    fun checkAlreadyUser(email : String){
        //회원 가입한 유저인지 판단합니다.
        mainRepository.getComments()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ list ->
                doSigninCallback.call()
            }, {
                Log.d("MyTag", it.localizedMessage)
            })
        //doSignupCallback.call()
    }

    fun onSignin(password : String) {
        doSigninFinishCallback
    }
}