package kr.yapp.teamplay.presentation.match_schedule

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.TeamPlayApplication
import kr.yapp.teamplay.databinding.ActivityMatchScheduleBinding
import kr.yapp.teamplay.presentation.matchresultinput.MatchResultInputActivity
import kr.yapp.teamplay.util.PreferenceManager

class MatchScheduleActivity : AppCompatActivity() {

    private var clubId: String = "1"
    private lateinit var binding: ActivityMatchScheduleBinding

    private val viewModel: MatchScheduleViewModel by lazy {
        ViewModelProvider(this).get(MatchScheduleViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        clubId = PreferenceManager.getSelectedTeamId(TeamPlayApplication.appContext).toString()
        setDataBinding()
        setLiveDataObserver()
        setRecyclerView()
        getItem()
    }

    private fun getItem() {
        viewModel.fetchScheduleItem(clubId)
    }

    private fun setRecyclerView() {
        binding.matchScheduleRecyclerivew.run {
            layoutManager =
                LinearLayoutManager(this@MatchScheduleActivity, RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()

            setHasFixedSize(true)

            adapter = MatchScheduleOuterAdapter(
                mutableListOf(), viewModel
            )
        }
    }

    private fun setLiveDataObserver() {
        viewModel.startMatchResultInput.observe(this, Observer { matchId ->
            val intent = Intent(this, MatchResultInputActivity::class.java)
            intent.putExtra("matchId", matchId);
            startActivity(intent)
        })
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_schedule)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}