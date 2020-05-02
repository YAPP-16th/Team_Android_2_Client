package kr.yapp.teamplay.presentation.signin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_signin.*
import kotlinx.android.synthetic.main.fragment_signin_email.*
import kotlinx.android.synthetic.main.fragment_signin_password.*
import kotlinx.android.synthetic.main.fragment_signup_email.*
import kotlinx.android.synthetic.main.fragment_signup_nickname.*
import kotlinx.android.synthetic.main.fragment_signup_password.*
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivitySigninBinding

class SigninActivity : AppCompatActivity(){

    private val signinViewModel: SigninViewModel by lazy {
        ViewModelProvider(this).get(SigninViewModel::class.java)
    }

    private val signupViewModel: SignupViewModel by lazy {
        ViewModelProvider(this).get(SignupViewModel::class.java)
    }

    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDataBinding()
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, SigninEmailFragment()).commit()
        setLiveDataObserver()
    }

    fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signin)
        binding.lifecycleOwner = this
        binding.signinViewModel = signinViewModel
        binding.signupViewModel = signupViewModel
    }

    fun setLiveDataObserver(){
        signinViewModel.signInEmailClick.observe(this, Observer {
            signinViewModel.checkAlreadyUser(input_email.editText.toString())
        })

        /*
        already registered input email
         */
        signinViewModel.signInStart.observe(this, Observer {
            goToSigninPassword()
            btn_next.visibility = View.INVISIBLE
            btn_signin_finish.visibility = View.VISIBLE
        })

        /*
        not registered input email
         */
        signinViewModel.signUpStart.observe(this, Observer {
            goToSignupEmail()
            btn_next.visibility = View.INVISIBLE
            btn_signup_email.visibility = View.VISIBLE
        })

        /*
        submit password for signin in signinpassword Page
         */
        signinViewModel.signInPasswordClick.observe(this, Observer {
            signinViewModel.inputSignInPassword(input_password.editText.toString())
        })

        /*
        success Signin
         */
        signinViewModel.signInPasswordFinish.observe(this, Observer {
            goToMain()
        })

        signupViewModel.signUpEmailClick.observe(this, Observer {
            signupViewModel.inputSignUpEmail(input_signup_email.editText.toString())
        })

        signupViewModel.signUpEmailFinish.observe(this, Observer {
            goToSignupPassword()
            btn_signup_email.visibility = View.INVISIBLE
            btn_signup_password.visibility = View.VISIBLE
        })

        signupViewModel.signUpPasswordClick.observe(this, Observer {
            signupViewModel.inputSignUpPassword(input_signup_password.editText.toString())
        })

        signupViewModel.signUpPasswordFinish.observe(this, Observer {
            goToSignupNickname()
            btn_signup_password.visibility = View.INVISIBLE
            btn_signup_nickname.visibility = View.VISIBLE
        })

        signupViewModel.signUpNicknameClick.observe(this, Observer {
            signupViewModel.inputSignUpNickname(input_signup_nickname.editText.toString())
        })

        signupViewModel.signUpNicknameFinsih.observe(this, Observer {
            goToMain()
        })
    }

    fun goToSigninPassword(){
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.fragment_close_enter,R.anim.fragment_open_exit).replace(R.id.fragment_container, SigninPasswordFragment()).commit()
    }

    fun goToSignupEmail(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SignupEmailFragment()).commit()
    }

    fun goToSignupPassword(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SignupPasswordFragment()).commit()
    }

    fun goToSignupNickname(){
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SignupNicknameFragment()).commit()
    }

    fun goToMain(){

    }
}