package kr.yapp.teamplay.presentation.onboarding

import android.util.Log
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeV2ResponseCallback
import com.kakao.usermgmt.response.MeV2Response
import com.kakao.usermgmt.response.model.Profile
import com.kakao.util.OptionalBoolean
import com.kakao.util.exception.KakaoException


class KakaoSessionCallback : ISessionCallback {
    override fun onSessionOpened() {
        requestMe()
    }

    // 로그인에 실패한 상태
    override fun onSessionOpenFailed(exception: KakaoException) {
        Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.message)
    }

    // 사용자 정보 요청
    fun requestMe(): Unit { // 사용자정보 요청 결과에 대한 Callback
        UserManagement.getInstance().me(object : MeV2ResponseCallback() {
            // 세션 오픈 실패. 세션이 삭제된 경우,
            override fun onSessionClosed(errorResult: ErrorResult) {
                Log.e(
                    "SessionCallback :: ", "onSessionClosed : " + errorResult.errorMessage
                )
            }

            // 사용자 정보 요청 실패
            override fun onFailure(errorResult: ErrorResult) {
                Log.e(
                    "SessionCallback :: ", "onFailure : " + errorResult.errorMessage
                )
            }

            override fun onSuccess(result: MeV2Response?) {
                Log.i("KAKAO_API", "사용자 아이디: " + result!!.id)

                val kakaoAccount = result.kakaoAccount

                if (kakaoAccount != null){
                    // 이메일
                    val email = kakaoAccount.email

                    if (email != null) {
                        Log.i("KAKAO_API", "email: " + email);

                    } else if (kakaoAccount.emailNeedsAgreement() == OptionalBoolean.TRUE) {
                        // 동의 요청 후 이메일 획득 가능
                        // 단, 선택 동의로 설정되어 있다면 서비스 이용 시나리오 상에서 반드시 필요한 경우에만 요청해야 합니다.

                    } else {
                        // 이메일 획득 불가
                    }
                }

                // 프로필
                val profile: Profile = kakaoAccount.profile

                if (profile != null) {
                    Log.d("KAKAO_API", "nickname: " + profile.getNickname());
                    Log.d("KAKAO_API", "profile image: " + profile.getProfileImageUrl());
                    Log.d("KAKAO_API", "thumbnail image: " + profile.getThumbnailImageUrl());

                } else if (kakaoAccount.profileNeedsAgreement() == OptionalBoolean.TRUE) {
                    // 동의 요청 후 프로필 정보 획득 가능

                } else {
                    // 프로필 획득 불가
                }
            }
        })
    }
}