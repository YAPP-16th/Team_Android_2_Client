package kr.yapp.teamplay.presentation.matchresultinput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityMatchResultInputBinding

class MatchResultInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchResultInputBinding

    private val viewModel: MatchResultInputViewModel by lazy {
        ViewModelProvider(this).get(MatchResultInputViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        setLiveDataObserver()
    }


    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_result_input)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }


    private fun setLiveDataObserver() {
        viewModel.onAddScoreTvClick.observe(this, Observer {
            val subScoreActivity = SubScoreDetailActivity(this)
            binding.matchResultInputScoreDetailLayout.addView(subScoreActivity)
        })

        viewModel.onAddRecordTvClick.observe(this, Observer {
            val subRecordActivity = SubPersonalRecordActivity(this)
            binding.matchResultInputPersonalScoreLayout.addView(subRecordActivity)
        })
    }
}