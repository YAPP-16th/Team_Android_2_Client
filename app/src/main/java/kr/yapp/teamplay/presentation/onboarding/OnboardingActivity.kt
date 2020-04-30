package kr.yapp.teamplay.presentation.onboarding

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kakao.auth.*
import com.kakao.auth.Session.getCurrentSession
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler
import com.nhn.android.naverlogin.data.OAuthLoginState
import kotlinx.android.synthetic.main.activity_onboarding.*
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityOnboardingBinding
import kr.yapp.teamplay.presentation.signin.SigninActivity

class OnboardingActivity : AppCompatActivity() {

    private val viewModel: OnboardingViewModel by lazy {
        ViewModelProvider(this).get(OnboardingViewModel::class.java)
    }
    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDataBinding()
        setObserveLiveData()

    }

    private fun setObserveLiveData() {
        viewModel.clickKakaoLoginCallback.observe(this, Observer {
            goToSignin()
        })

        viewModel.clickNaverLoginCallback.observe(this, Observer {
            goToSignin()
        })

        viewModel.clickGoogleLoginCallback.observe(this, Observer {
            goToSignin()
        })
    }

    fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_onboarding)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    fun goToSignin() {
        intent = Intent(this, SigninActivity::class.java)
        startActivity(intent)
        finish()
    }
/*
//착오로 SNS 연동 로그인 작업을 하던 구간입니다.
    fun initKakaoSDK() {
        // SDK 초기화
        KakaoSDK.init(object : KakaoAdapter() {
            // Application이 가지고 있는 정보를 얻기 위한 인터페이스
            override fun getApplicationConfig(): IApplicationConfig? {
                return object : IApplicationConfig {
                    val topActivity: Activity?
                        get() = null

                    override fun getApplicationContext(): Context {
                        return this@OnboardingActivity.applicationContext
                    }
                }
            }

            override fun getSessionConfig(): ISessionConfig? {
                return object : ISessionConfig {
                    override fun getAuthTypes(): Array<AuthType> {
                        return arrayOf(AuthType.KAKAO_LOGIN_ALL)
                    }

                    override fun isUsingWebviewTimer(): Boolean {
                        return false
                    }

                    override fun isSecureMode(): Boolean {
                        return false
                    }

                    override fun getApprovalType(): ApprovalType? {
                        return ApprovalType.INDIVIDUAL
                    }

                    override fun isSaveFormData(): Boolean {
                        return true
                    }
                }
            }
        })
    }

    private fun nhnSignIn() {
        // 연동 해제 시 주석 풀기 (클라이언트, 서버 모두 삭제)
        // val isSuccessDeleteToken = nhnOAuthLoginModule.logoutAndDeleteToken(this@LoginActivity)
        // nhnOAuthLoginModule.logout(this@LoginActivity)

        if (nhnOAuthLoginModule.getState(this@OnboardingActivity) == OAuthLoginState.OK) {
            Log.d("MyTag", "Nhn status don't need login")
            RequestNHNLoginApiTask().execute()
        } else {
            Log.d("MyTag", "Nhn status need login")
            nhnOAuthLoginModule.startOauthLoginActivity(this, @SuppressLint("HandlerLeak")
            object : OAuthLoginHandler() {
                override fun run(success: Boolean) {
                    if (success) {
                        val accessToken =
                            nhnOAuthLoginModule.getAccessToken(this@OnboardingActivity)
                        val refreshToken =
                            nhnOAuthLoginModule.getRefreshToken(this@OnboardingActivity)
                        val expiresAt = nhnOAuthLoginModule.getExpiresAt(this@OnboardingActivity)
                        val tokenType = nhnOAuthLoginModule.getTokenType(this@OnboardingActivity)
                        Log.i("MyTag", "nhn Login Access Token : $accessToken")
                        Log.i("MyTag", "nhn Login refresh Token : $refreshToken")
                        Log.i("MyTag", "nhn Login expiresAt : $expiresAt")
                        Log.i("MyTag", "nhn Login Token Type : $tokenType")
                        Log.i(
                            "MyTag",
                            "nhn Login Module State : " + nhnOAuthLoginModule.getState(this@OnboardingActivity).toString()
                        )
                        goToSignin()
                    } else {
                        val errorCode =
                            nhnOAuthLoginModule.getLastErrorCode(this@OnboardingActivity).getCode()
                        val errorDesc =
                            nhnOAuthLoginModule.getLastErrorDesc(this@OnboardingActivity)
                        Toast.makeText(
                            this@OnboardingActivity,
                            "errorCode:$errorCode, errorDesc:$errorDesc",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            })
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, @Nullable data: Intent?
    ) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    inner class RequestNHNLoginApiTask : AsyncTask<Void, Void, String>() {
        override fun onPostExecute(result: String?) {
            Log.d("MyTag", "onPreExecute : $result")
            val startToken = "<message>"
            val endToken = "</message>"
            val startIndex = result?.indexOf(startToken) ?: -1
            val endIndex = result?.indexOf(endToken) ?: -1
            if (startIndex == -1 || endIndex <= 0) {
                return
            }
            val message = result?.substring(startIndex + startToken.length, endIndex)?.trim()
            if (message.equals("success")) {
                Log.d("MyTag", "Success RequestNHNLoginApiTask")
                goToSignin()
            } else {
                Log.e("MyTag", "Login Fail")
            }
        }

        override fun doInBackground(vararg params: Void?): String {
            val url = "https://apis.naver.com/nidlogin/nid/getHashId_v2.xml"
            val at = nhnOAuthLoginModule.getAccessToken(this@OnboardingActivity)
            return nhnOAuthLoginModule.requestApi(this@OnboardingActivity, at, url)
        }

        override fun onPreExecute() {

        }

    }
    private lateinit var session: Session
    // 세션 콜백 구현
    private val sessionCallback: ISessionCallback = KakaoSessionCallback()

    // 네이버 로그인 모듈
    private lateinit var nhnOAuthLoginModule: OAuthLogin

    //initKakaoSDK()
        btn_kakao.setOnClickListener {
            // 세션 콜백 등록
            session = getCurrentSession()
            session.addCallback(sessionCallback)
            session.open(AuthType.KAKAO_LOGIN_ALL, this)
        }

        //네이버 로그인
        nhnOAuthLoginModule = OAuthLogin.getInstance()
        nhnOAuthLoginModule.init(
            this, getString(R.string.nhn_oauth_client_id)
            , getString(R.string.nhn_oauth_client_secret)
            , getString(R.string.nhn_oauth_client_name)
        )

        btn_naver.setOnClickListener {
            nhnSignIn()
        }
    */
}
