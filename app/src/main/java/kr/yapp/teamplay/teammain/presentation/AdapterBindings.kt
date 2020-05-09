package kr.yapp.teamplay.teammain.presentation

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.teammain.data.TeamMainFeedItem

@BindingAdapter("bind:item")
fun bindItem(recyclerView: RecyclerView, list: List<TeamMainFeedItem>?) {
    var todoAdapter: TeamMainAdapter = recyclerView.adapter as TeamMainAdapter
    if (!list.isNullOrEmpty()) todoAdapter.updateTeamMain(list)
}