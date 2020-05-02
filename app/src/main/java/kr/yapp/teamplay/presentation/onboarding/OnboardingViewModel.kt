package kr.yapp.teamplay.presentation.onboarding

import android.view.View
import androidx.lifecycle.ViewModel
import kr.yapp.teamplay.presentation.util.SingleLiveEvent

class OnboardingViewModel : ViewModel(){
    val kakaoLoginClick : SingleLiveEvent<Void> = SingleLiveEvent()
    val naverLoginClick : SingleLiveEvent<Void> = SingleLiveEvent()
    val googleLoginClick : SingleLiveEvent<Void> = SingleLiveEvent()

    fun clickKaKaoLoginButton(){
        kakaoLoginClick.call()
    }

    fun clickNaverLoginButton(){
        naverLoginClick.call()
    }

    fun clickGoogleLoginButton(){
        googleLoginClick.call()
    }
}