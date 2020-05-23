package kr.yapp.teamplay.presentation.search

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityTeamSearchBinding

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
class TeamSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamSearchBinding
    private val teamListAdapter: TeamListAdapter = TeamListAdapter()

    private val viewModel: TeamSearchViewModel by lazy {
        ViewModelProvider(this).get(TeamSearchViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setRecyclerView()
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_search)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setRecyclerView() {
        with(binding.teamList) {
            layoutManager = LinearLayoutManager(this@TeamSearchActivity)
            itemAnimator = DefaultItemAnimator()
            adapter = teamListAdapter
        }
    }
}
