package kr.yapp.teamplay.presentation.match_list

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityMatchSearchBinding
import kr.yapp.teamplay.domain.entity.Search
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.textColor
import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.*

class MatchSearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchSearchBinding
    private lateinit var search : Search
    private lateinit var minDate : Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setDataBinding()
        setViewListener()
        setInitView()
        transStatusWhiteTextBar()
    }

    private fun setInitView() {
        val dateFormat = SimpleDateFormat("yyyy년 MM월 dd일")
        val currentTime = dateFormat.format(System.currentTimeMillis()).toString()
        binding.searchStartDate.hint = currentTime
        binding.searchEndDate.hint = currentTime
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_match_search)
        binding.lifecycleOwner = this
        search = Search()
    }

    private fun setViewListener() {
        val startDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val stringBuilder = stringBuilder(year, month, dayOfMonth)
            minDate = Calendar.getInstance()
            minDate.set(year, month, dayOfMonth)

            search.startTime = stringBuilder.toString()
            binding.searchStartDate.text = search.startTime
            binding.searchStartDate.background = resources.getDrawable(R.drawable.item_search_active_label)
        }

        val endDateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            val stringBuilder = stringBuilder(year, month, dayOfMonth)

            search.endTime = stringBuilder.toString()
            binding.searchEndDate.text = search.endTime
            binding.searchEndDate.background = resources.getDrawable(R.drawable.item_search_active_label)
        }

        binding.searchStartDate.setOnClickListener {
            getDatePickerDialog(startDateSetListener).show()
        }

        binding.searchEndDate.setOnClickListener {
            val datePickerDialog = getDatePickerDialog(endDateSetListener)
            datePickerDialog.datePicker.minDate = minDate.timeInMillis
            datePickerDialog.show()
        }

        binding.searchThreeOnThree.setOnClickListener {
            binding.searchThreeOnThree.setOnCheckedChangeListener { buttonView, isChecked ->
                changeButtonColor(buttonView, isChecked)
            }
        }

        binding.searchFiveOnFiveHalf.setOnClickListener {
            binding.searchFiveOnFiveHalf.setOnCheckedChangeListener { buttonView, isChecked ->
                changeButtonColor(buttonView, isChecked)
            }
        }

        binding.searchFiveOnFiveFull.setOnClickListener {
            binding.searchFiveOnFiveFull.setOnCheckedChangeListener { buttonView, isChecked ->
                changeButtonColor(buttonView, isChecked)
            }
        }

        binding.searchEtc.setOnClickListener {
            binding.searchEtc.setOnCheckedChangeListener { buttonView, isChecked ->
                changeButtonColor(buttonView, isChecked)
            }
        }

        binding.searchSubmit.setOnClickListener {
            search.location = binding.searchEtLocation.text.toString()
            finishSearchActivity()
        }
    }

    private fun finishSearchActivity() {
        val intent = Intent()
        intent.putExtra("search", search)
        setResult(2, intent)
        finish()
    }

    private fun changeButtonColor(buttonView : Button, isChecked : Boolean) {
        if (isChecked) {
            buttonView.background = resources.getDrawable(R.drawable.item_search_active_label)
            buttonView.backgroundColor = resources.getColor(R.color.colorBasketBallRed2)
            buttonView.textColor = resources.getColor(R.color.colorWhite)
        } else {
            buttonView.background = resources.getDrawable(R.drawable.item_search_deactive_label)
            buttonView.textColor = resources.getColor(R.color.colorWireFrameBackground)
        }
    }

    private fun stringBuilder(
        year: Int,
        month: Int,
        dayOfMonth: Int
    ): StringBuilder {
        val stringBuilder = StringBuilder()
        stringBuilder.append(year).append("년")
            .append(month+1).append("월")
            .append(dayOfMonth).append("일")

        return stringBuilder
    }

    private fun getDatePickerDialog(dateSetListener: DatePickerDialog.OnDateSetListener): DatePickerDialog {
        val cal = Calendar.getInstance()
        cal.timeInMillis
        return DatePickerDialog(this, dateSetListener
            , cal.get(Calendar.YEAR)
            , cal.get(Calendar.MONTH)
            , cal.get(Calendar.DAY_OF_WEEK))
    }

    private fun transStatusWhiteTextBar() {
        window.run {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = resources.getColor(R.color.colorBasketBallRed2)
        }
    }
}
