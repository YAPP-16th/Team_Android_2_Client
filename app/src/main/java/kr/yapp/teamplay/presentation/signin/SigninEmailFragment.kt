package kr.yapp.teamplay.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_signin_email.*
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.FragmentSigninEmailBinding

class SigninEmailFragment : Fragment() {

    private val viewModel : SigninViewModel by lazy {
        ViewModelProvider(this).get(SigninViewModel::class.java)
    }
    private lateinit var binding: FragmentSigninEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_signin_email, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }
}