package kr.yapp.teamplay.presentation.matchresultinput

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityMatchResultInputBinding
import org.jetbrains.anko.toast

class MatchResultInputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchResultInputBinding

    private val viewModel: MatchResultInputViewModel by lazy {
        ViewModelProvider(this).get(MatchResultInputViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val matchId = intent.getIntExtra("matchId", -1)
        setDataBinding()
        setLiveDataObserver(matchId)
        setRecyclerView()
        initItem()
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_result_input)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }


    private fun setLiveDataObserver(matchId: Int) {
        viewModel.onAddScoreTvClick.observe(this, Observer {
            viewModel.addScoreDetail()
        })

        viewModel.onAddRecordTvClick.observe(this, Observer {
            viewModel.addRecordDetail()
        })

        viewModel.onClickRegisterResult.observe(this, Observer {
            viewModel.registerResult(matchId)
        })
        viewModel.onFinishRegister.observe(this, Observer {
            finish()
            toast("결과가 등록되었습니다")
        })
    }

    private fun setRecyclerView() {
        binding.matchResultInputScoreDetailLayout.run {
            layoutManager =
                LinearLayoutManager(this@MatchResultInputActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = ScoreDetailAdapter(mutableListOf())
        }

        binding.matchResultInputPersonalScoreLayout.run {
            layoutManager =
                LinearLayoutManager(this@MatchResultInputActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            adapter = PersonalRecordAdapter(mutableListOf())
        }
    }

    private fun initItem() {
        viewModel.addScoreDetail()
        viewModel.addRecordDetail()
    }

}