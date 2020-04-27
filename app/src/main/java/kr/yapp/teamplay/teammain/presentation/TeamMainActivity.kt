package kr.yapp.teamplay.teammain.presentation

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityTeamMainBinding

class TeamMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamMainBinding

    private val viewModel: TeamMainViewModel by lazy {
        ViewModelProvider(this).get(TeamMainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        transStatusWhiteTextBar()
    }

    override fun onResume() {
        super.onResume()
        getTeamMainItem()
    }

    private fun getTeamMainItem() {
        viewModel.fetchTeamMainItem()
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_team_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun transStatusWhiteTextBar() {
        window.run {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT
        }
    }


}