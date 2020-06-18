/*
 * Created by Lee Oh Hyoung on 2020/06/18 .. 
 */
package kr.yapp.teamplay.presentation.match_result.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.databinding.ItemMatchResultIndividualBinding
import kr.yapp.teamplay.domain.entity.matchresult.MatchIndividualScore

class MatchIndividualAdapter(
    private val individual: List<MatchIndividualScore>
) : RecyclerView.Adapter<MatchIndividualAdapter.MatchIndividualViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchIndividualViewHolder {
        return MatchIndividualViewHolder(
            ItemMatchResultIndividualBinding.inflate(LayoutInflater.from(parent.context), null, false)
        )
    }

    override fun onBindViewHolder(holder: MatchIndividualViewHolder, position: Int) {
        holder.bindTo(individual[position])
    }

    override fun getItemCount(): Int = individual.size

    inner class MatchIndividualViewHolder(
        private val binding: ItemMatchResultIndividualBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindTo(score: MatchIndividualScore) {
            binding.scoreType = score
        }
    }
}
