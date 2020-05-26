package kr.yapp.teamplay.presentation.match_schedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityMatchScheduleBinding

class MatchScheduleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMatchScheduleBinding

    private val viewModel: MatchScheduleViewModel by lazy {
        ViewModelProvider(this).get(MatchScheduleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        setLiveDataObserver()
        setRecyclerView()
        getItem()
    }

    private fun getItem() {
        viewModel.fetchScheduleItem()
    }

    private fun setRecyclerView() {
        binding.matchScheduleRecyclerivew.run {
            layoutManager =
                LinearLayoutManager(this@MatchScheduleActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()

            setHasFixedSize(true)

            adapter = MatchScheduleOuterAdapter(
                mutableListOf()
            )
        }
    }

    private fun setLiveDataObserver() {
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_schedule)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}