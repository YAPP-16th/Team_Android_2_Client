package kr.yapp.teamplay.presentation.signin

import android.view.View
import androidx.lifecycle.ViewModel
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class SignupViewModel : ViewModel() {
    val signUpEmailClick : SingleLiveEvent<Void> = SingleLiveEvent()
    val signUpPasswordClick : SingleLiveEvent<Void> = SingleLiveEvent()
    val signUpNicknameClick : SingleLiveEvent<Void> = SingleLiveEvent()
    val signUpEmailFinish : SingleLiveEvent<Void> = SingleLiveEvent()
    val signUpPasswordFinish : SingleLiveEvent<Void> = SingleLiveEvent()
    val signUpNicknameFinsih : SingleLiveEvent<Void> = SingleLiveEvent()

    fun clickSignUpEmailButton() {
        signUpEmailClick.call()
    }

    fun clickSignUpPasswordButton() {
        signUpPasswordClick.call()
    }

    fun clickSignUpNicknameButton() {
        signUpNicknameClick.call()
    }

    fun inputSignUpEmail(email : String) {
        //유효한 이메일인지 체크
        signUpEmailFinish.call()
    }

    fun inputSignUpPassword(password : String) {
        //유효한 패스워드인지 체크
        signUpPasswordFinish.call()
    }

    fun inputSignUpNickname(nickname : String) {
        //유효한 닉네임인지 체크
        signUpNicknameFinsih.call()
    }
}