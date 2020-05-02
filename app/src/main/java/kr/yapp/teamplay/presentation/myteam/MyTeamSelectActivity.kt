/*
 * Created by Lee Oh Hyoung on 2020/04/30 .. 
 */
package kr.yapp.teamplay.presentation.myteam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivitySelectMyTeamBinding
import kr.yapp.teamplay.domain.entity.MyTeam

class MyTeamSelectActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "MyTeamSelectActivity"
    }

    private lateinit var binding: ActivitySelectMyTeamBinding

    private val viewModel: MyTeamSelectViewModel by lazy {
        ViewModelProvider(this).get(MyTeamSelectViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setRecyclerView()
    }

    private fun setBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_select_my_team)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setRecyclerView() {
        binding.myTeamList.run {
            layoutManager = LinearLayoutManager(this@MyTeamSelectActivity, RecyclerView.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            adapter = MyTeamAdapter().apply {
                updateMyTeam(listOf(MyTeam(), MyTeam(), MyTeam()))
            }
            object:PagerSnapHelper() {
                override fun attachToRecyclerView(recyclerView: RecyclerView?) {
                    super.attachToRecyclerView(recyclerView)
                    /* explicitly empty */
                }
            }.attachToRecyclerView(this)
        }
    }

}
