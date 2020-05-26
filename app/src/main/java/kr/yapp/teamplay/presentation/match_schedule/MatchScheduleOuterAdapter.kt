package kr.yapp.teamplay.presentation.match_schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.RvItemOuterMatchSchduleBinding
import kr.yapp.teamplay.domain.entity.matchschedule.MatchScheduleOuterItem

class MatchScheduleOuterAdapter(
    private var list: MutableList<MatchScheduleOuterItem>
) : RecyclerView.Adapter<MatchScheduleOuterAdapter.OuterViewHolder>() {

    inner class OuterViewHolder(
        private val binding: RvItemOuterMatchSchduleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(outerItem: MatchScheduleOuterItem) {
            binding.outerItem = outerItem
            binding.itemOuterMatchRecyclerView.run {
                layoutManager =
                    LinearLayoutManager(binding.root.context, RecyclerView.VERTICAL, false)
                itemAnimator = DefaultItemAnimator()
                setHasFixedSize(true)
                adapter = MatchScheduleInnerAdapter(
                    outerItem.matchScheduleInfo,
                    outerItem.matchScheduleType
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OuterViewHolder {
        return OuterViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.rv_item_outer_match_schdule,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: OuterViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    fun updateMatchSchedule(updatedList: List<MatchScheduleOuterItem>) {
        list.clear()
        list.addAll(updatedList)
        notifyDataSetChanged()
    }
}

@BindingAdapter("bindSchedule:outerItem")
fun bindScheduleOuterItem(recyclerView: RecyclerView, list: List<MatchScheduleOuterItem>?) {
    if (list.isNullOrEmpty()) return
    val matchScheduleOuterAdapter = recyclerView.adapter as MatchScheduleOuterAdapter
    matchScheduleOuterAdapter.updateMatchSchedule(list)
}