package kr.yapp.teamplay.presentation.match_schedule

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.RvInnerItemMatchScheduleGeneralTypeBinding
import kr.yapp.teamplay.databinding.RvInnerItemMatchScheduleGuestTypeBinding
import kr.yapp.teamplay.databinding.RvInnerItemMatchScheduleHostTypeBinding
import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleInnerItem
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class MatchScheduleInnerAdapter(
    private var list: List<MatchScheduleInnerItem>,
    private var type: String,
    private val viewModel: MatchScheduleViewModel
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (type) {
            "THIS_SCHEDULE", "NEXT_SCHEDULE" -> {
                GeneralTypeViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.rv_inner_item_match_schedule_general_type,
                        parent, false
                    )
                )
            }
            "HOST" -> {
                HostTypeViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.rv_inner_item_match_schedule_host_type,
                        parent, false
                    )
                )
            }
            "GUEST" -> {
                GuestTypeViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.rv_inner_item_match_schedule_guest_type,
                        parent, false
                    )
                )
            }
            else -> throw IllegalArgumentException("??")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (type) {
            "THIS_SCHEDULE", "NEXT_SCHEDULE" -> (holder as GeneralTypeViewHolder).bindTo(list[position])
            "HOST" -> (holder as HostTypeViewHolder).bindTo(list[position])
            "GUEST" -> (holder as GuestTypeViewHolder).bindTo(list[position])
        }
    }

    inner class GeneralTypeViewHolder(
        private val binding: RvInnerItemMatchScheduleGeneralTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bindTo(innerItem: MatchScheduleInnerItem) {
            binding.itemInnerMatchTitleTv.text = innerItem.title
            binding.itemInnerMatchDescription.text = innerItem.description
            binding.itemInnerMatchDateTv.text = innerItem.matchDate
            binding.itemInnerMatchTimeTv.text = innerItem.matchTime

            val formatterOfDate = DateTimeFormatter.ofPattern("yyyy MM월 dd일")
            val formatterOfDateTime = DateTimeFormatter.ofPattern("HH:mm")

            val itemDateTime = LocalDateTime.of(
                LocalDate.parse(LocalDate.now().year.toString() + " " + innerItem.matchDate, formatterOfDate),
                LocalTime.parse(innerItem.matchTime!!.split("-")[1].trim(), formatterOfDateTime)
            )
            if (itemDateTime.isBefore(LocalDateTime.now())) {
                binding.root.setOnClickListener {
                    viewModel.startMatchResultInput()
                }
            }
        }
    }

    inner class HostTypeViewHolder(
        private val binding: RvInnerItemMatchScheduleHostTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(innerItem: MatchScheduleInnerItem) {
            binding.viewModel = viewModel
            binding.context = binding.root.context
            binding.matchId = innerItem.matchRequestId.toString()
            binding.itemInnerHostTitleTv.text = innerItem.title
            binding.itemInnerMatchHostDescription.text = innerItem.description
        }
    }

    inner class GuestTypeViewHolder(
        private val binding: RvInnerItemMatchScheduleGuestTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(innerItem: MatchScheduleInnerItem) {
            binding.itemInnerMatchGuestTitleTv.text = innerItem.title
            binding.itemInnerMatchGuestDescription.text = innerItem.description
            when (innerItem.requestStatus) {
                "WAITING" -> binding.itemInnerMatchGuestStatus.text = "수락 대기 중"
                "ACCEPT" -> {
                    binding.itemInnerMatchGuestStatus.text = "수락됨"
                    binding.run { itemInnerMatchGuestStatus.setTextColor(Color.parseColor("#15ce79")) }
                }
                "REJECT" -> {
                    binding.itemInnerMatchGuestStatus.text = "거절됨"
                    binding.run { itemInnerMatchGuestStatus.setTextColor(Color.parseColor("#ff4d41")) }
                }
            }
        }
    }
}