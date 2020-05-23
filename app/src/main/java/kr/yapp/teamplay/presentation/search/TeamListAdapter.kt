package kr.yapp.teamplay.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.data.search.TeamList
import kr.yapp.teamplay.databinding.ItemTeamListBinding
import kr.yapp.teamplay.databinding.ItemTeamListHeaderBinding
import kr.yapp.teamplay.presentation.util.Bindable
import kr.yapp.teamplay.presentation.util.BindableData

/**
 * Created by Lee Oh Hyoung on 2020/05/23.
 */
class TeamListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ViewType {
        HEADER, LIST
    }

    private val bindableData: MutableList<BindableData> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(ViewType.values()[viewType]) {
            ViewType.HEADER -> TeamListHeaderViewHolder(
                DataBindingUtil
                    .inflate(LayoutInflater.from(parent.context),
                        R.layout.item_team_list_header, parent, false)
            )
            ViewType.LIST -> TeamListViewHolder(
                DataBindingUtil
                    .inflate(LayoutInflater.from(parent.context),
                        R.layout.item_team_list, parent, false)
            )
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? Bindable<BindableData>)?.bindTo(bindableData[position])
    }

    override fun getItemCount(): Int = bindableData.count()

    private class TeamListHeaderViewHolder(
        private val binding: ItemTeamListHeaderBinding
    ) : RecyclerView.ViewHolder(binding.root), Bindable<TeamListHeaderViewHolder.Item> {

        class Item(val count: Int = 13) : BindableData(ViewType.HEADER.ordinal)

        override fun bindTo(item: Item) {
            binding.count = item.count
        }
    }

    private class TeamListViewHolder (
        private val binding: ItemTeamListBinding
    ) : RecyclerView.ViewHolder(binding.root), Bindable<TeamListViewHolder.Item> {

        class Item(val teamList: TeamList) : BindableData(ViewType.LIST.ordinal)

        override fun bindTo(item: Item) {
            binding.team = item.teamList
        }
    }
}
