package kr.yapp.teamplay.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.FragmentSignupPasswordBinding

class SignupPasswordFragment : Fragment() {
    private val viewModel : SigninViewModel by lazy {
        ViewModelProvider(this).get(SigninViewModel::class.java)
    }
    private lateinit var binding: FragmentSignupPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_signup_password, container, false)
        binding.lifecycleOwner = this

        return binding.root
    }
}