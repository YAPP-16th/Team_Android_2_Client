package kr.yapp.teamplay.presentation.matchresultinput

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.SubMatchResultInputPersonalRecordBinding
import kr.yapp.teamplay.domain.entity.matchresultinput.PersonalRecordItem

class PersonalRecordAdapter(
    private var list: MutableList<PersonalRecordItem>
) : RecyclerView.Adapter<PersonalRecordAdapter.ViewHolder>() {


    inner class ViewHolder(
        private val binding: SubMatchResultInputPersonalRecordBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: PersonalRecordItem) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.sub_match_result_input_personal_record,
                parent, false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    fun update(updatedList: List<PersonalRecordItem>) {
        list.clear()
        list.addAll(updatedList)
        notifyDataSetChanged()
    }
}

@BindingAdapter("bindRecord:item")
fun bindRecordItem(recyclerView: RecyclerView, list: List<PersonalRecordItem>?) {
    if (list.isNullOrEmpty()) return
    val adapter = recyclerView.adapter as PersonalRecordAdapter
    adapter.update(list)
}