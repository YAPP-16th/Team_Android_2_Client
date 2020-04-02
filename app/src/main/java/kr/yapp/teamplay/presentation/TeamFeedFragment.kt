package kr.yapp.teamplay.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.FragmentTeamFeedBinding

class TeamFeedFragment : Fragment() {
    private lateinit var binding : FragmentTeamFeedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_team_feed, container, false)

        val args = TeamFeedFragmentArgs.fromBundle(arguments!!)

        binding.teamName = args.teamName

        return binding.root
    }
}
