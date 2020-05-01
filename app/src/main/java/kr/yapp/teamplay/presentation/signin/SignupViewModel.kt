package kr.yapp.teamplay.presentation.signin

import android.view.View
import androidx.lifecycle.ViewModel
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class SignupViewModel : ViewModel() {
    val clickSignupEmailCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickSignupPasswordCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickSignupNicknameCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val doSignupEmailCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val doSignupPasswordCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val doSignupNicknameCallback : SingleLiveEvent<Void> = SingleLiveEvent()

    fun clickSignupEmailButton(view : View) {
        clickSignupEmailCallback.call()
    }

    fun clickSignupPasswordButton(view : View) {
        clickSignupPasswordCallback.call()
    }

    fun clickSignupNicknameButton(view : View) {
        clickSignupNicknameCallback.call()
    }

    fun onSignupEmail(email : String) {
        //유효한 이메일인지 체크
        doSignupEmailCallback.call()
    }

    fun onSignupPassword(password : String) {
        //유효한 패스워드인지 체크
        doSignupPasswordCallback.call()
    }

    fun onSignupNickname(nickname : String) {
        //유효한 닉네임인지 체크
        doSignupNicknameCallback.call()
    }
}