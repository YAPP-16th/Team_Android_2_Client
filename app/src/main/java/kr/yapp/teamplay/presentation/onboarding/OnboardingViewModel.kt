package kr.yapp.teamplay.presentation.onboarding

import android.view.View
import androidx.lifecycle.ViewModel
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class OnboardingViewModel : ViewModel(){
    val clickKakaoLoginCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickNaverLoginCallback : SingleLiveEvent<Void> = SingleLiveEvent()
    val clickGoogleLoginCallback : SingleLiveEvent<Void> = SingleLiveEvent()

    fun clickKaKaoLoginButton(view : View){
        clickKakaoLoginCallback.call()
    }

    fun clickNaverLoginButton(view : View){
        clickNaverLoginCallback.call()
    }

    fun clickGoogleLoginButton(view : View){
        clickGoogleLoginCallback.call()
    }

    fun signinKaKao(){

    }

    fun signinNaver(){

    }

    fun signinGoogle(){

    }
}