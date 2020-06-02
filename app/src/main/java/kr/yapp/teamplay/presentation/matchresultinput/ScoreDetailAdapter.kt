package kr.yapp.teamplay.presentation.matchresultinput

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.SubMatchResultInputScoreDetailBinding
import kr.yapp.teamplay.domain.entity.matchresultinput.ScoreDetailItem

class ScoreDetailAdapter(
    private var list: MutableList<ScoreDetailItem>
) : RecyclerView.Adapter<ScoreDetailAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: SubMatchResultInputScoreDetailBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: ScoreDetailItem) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.sub_match_result_input_score_detail,
                parent, false
            )
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(list[position])
    }

    fun update(updatedList: List<ScoreDetailItem>) {
        list.clear()
        list.addAll(updatedList)
        notifyDataSetChanged()
    }

}

@BindingAdapter("bindScore:item")
fun bindScoreDetailItem(recyclerView: RecyclerView, list: List<ScoreDetailItem>?) {
    if (list.isNullOrEmpty()) return
    val adapter = recyclerView.adapter as ScoreDetailAdapter
    adapter.update(list)
}