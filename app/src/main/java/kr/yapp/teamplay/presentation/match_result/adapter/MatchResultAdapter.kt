/*
 * Created by Lee Oh Hyoung on 2020/06/18 .. 
 */
package kr.yapp.teamplay.presentation.match_result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ItemMatchResultScoreBinding
import kr.yapp.teamplay.databinding.ItemMatchResultScoreHeaderBinding
import kr.yapp.teamplay.domain.entity.matchresult.MatchResultScorePerType

class MatchResultAdapter(
    private val results: List<MatchResultScorePerType>,
    private val hostName: String,
    private val guestName: String
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        HEADER, RESULT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType) {
            ViewType.HEADER.ordinal -> {
                MatchResultHeaderViewHolder(
                    ItemMatchResultScoreHeaderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            ViewType.RESULT.ordinal -> {
                MatchResultViewHolder(
                    ItemMatchResultScoreBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
            else -> throw IllegalStateException("unsupported view holder type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is MatchResultHeaderViewHolder -> holder.bindTo(hostName = hostName, guestName = guestName)
            is MatchResultViewHolder -> holder.bindTo(score = results[position - 1])
        }
    }

    override fun getItemCount(): Int = (results.size + 1)

    override fun getItemViewType(position: Int): Int {
        return when(position) {
            0 -> ViewType.HEADER.ordinal
            else -> ViewType.RESULT.ordinal
        }
    }

    inner class MatchResultHeaderViewHolder(
        private val binding: ItemMatchResultScoreHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(hostName: String, guestName: String) {
            binding.hostName = hostName
            binding.guestName = guestName
        }
    }

    inner class MatchResultViewHolder(
        private val binding: ItemMatchResultScoreBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(score: MatchResultScorePerType) {
            binding.scoreType = score
            if(adapterPosition % 2 == 0) {
                binding.root.background = ContextCompat.getDrawable(itemView.context, R.color.very_light_pink)
            }
        }
    }
}
