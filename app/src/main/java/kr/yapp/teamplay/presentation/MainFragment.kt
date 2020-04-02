package kr.yapp.teamplay.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_main, container, false)

        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(MainFragmentDirections.actionMainFragmentToTeamFeedFragment("tempTeamName"))
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}
