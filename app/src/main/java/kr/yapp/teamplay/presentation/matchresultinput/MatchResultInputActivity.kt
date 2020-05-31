package kr.yapp.teamplay.presentation.matchresultinput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityMatchResultInputBinding

class MatchResultInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchResultInputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_result_input)
    }
}