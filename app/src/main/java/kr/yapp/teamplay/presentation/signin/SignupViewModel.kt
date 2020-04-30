package kr.yapp.teamplay.presentation.signin

import android.view.View
import androidx.lifecycle.ViewModel
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class SignupViewModel : ViewModel() {
    val clickSignupEmailCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickSignupPasswordCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickSignupNicknameCallback : SingleLiveEvent<Void> = SingleLiveEvent()

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

    }

    fun onSignupPassword(password : String) {

    }

    fun onSignupNickname(nickname : String) {

    }
}