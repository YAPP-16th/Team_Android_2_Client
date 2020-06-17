package kr.yapp.teamplay.presentation.creatematch

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityCreateMatchBinding
import kr.yapp.teamplay.domain.entity.matchlist.Search
import kr.yapp.teamplay.presentation.match_list.MatchListActivity
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class CreateMatchActivity : AppCompatActivity() {

    private lateinit var minDate: Calendar
    private val viewModel: CreateMatchViewModel by lazy {
        ViewModelProvider(this).get(CreateMatchViewModel::class.java)
    }

    private var search = Search()

    private lateinit var binding: ActivityCreateMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        setLiveDataObserver()

        setViewListener()

    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_match)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

    }

    private fun setLiveDataObserver() {
        viewModel.click.observe(this, androidx.lifecycle.Observer {
            finish()
        })
        viewModel.isCreated.observe(this, androidx.lifecycle.Observer { toast("생성이 완료되었습니다.") })
    }

    private fun setViewListener() {

        val startDateSetListener = TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val calendar = Calendar.getInstance()
            calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                hourOfDay,
                minute)
            val formatter = SimpleDateFormat("hh:mm:ss")
            search.startTime = formatter.format(calendar.time)

            binding.createMatchStartDate.text = search.startTime
            viewModel.requestCreateMatchViewDto.startDate.value = search.startTime
        }

        val endDateSetListener = TimePickerDialog.OnTimeSetListener { view, hour, minute ->
            val calendar = Calendar.getInstance()
            calendar.set(calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                hour,
                minute)
            val formatter = SimpleDateFormat("hh:mm:ss")
            search.endTime = formatter.format(calendar.time)

            binding.createMatchEndDate.text = search.endTime
            viewModel.requestCreateMatchViewDto.endDate.value = search.endTime
        }

        binding.createMatchStartDate.setOnClickListener {
            getPickerDialog(startDateSetListener).show()
        }

        binding.createMatchEndDate.setOnClickListener {
            getPickerDialog(endDateSetListener).show()
        }
    }

    private fun getPickerDialog(setListener: TimePickerDialog.OnTimeSetListener): TimePickerDialog {
        val cal = Calendar.getInstance()
        cal.timeInMillis
        return TimePickerDialog(
            this,
            setListener
            , cal.get(Calendar.HOUR_OF_DAY)
            , cal.get(Calendar.MINUTE)
            , true)
    }
}