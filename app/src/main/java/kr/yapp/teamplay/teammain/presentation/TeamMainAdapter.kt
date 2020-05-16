package kr.yapp.teamplay.teammain.presentation

import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.RvItemTeamMainNoticeTypeBinding
import kr.yapp.teamplay.databinding.RvItemTeamMainResultTypeBinding
import kr.yapp.teamplay.teammain.data.NoticeItem
import kr.yapp.teamplay.teammain.data.ResultItem
import kr.yapp.teamplay.teammain.data.TeamMainFeedItem

class TeamMainAdapter(
    private var list: MutableList<TeamMainFeedItem>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            0 -> {
                NoticeTypeViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.rv_item_team_main_notice_type,
                        parent,
                        false
                    )
                )
            }
            1 -> {
                ResultTypeViewHolder(
                    DataBindingUtil.inflate(
                        LayoutInflater.from(parent.context),
                        R.layout.rv_item_team_main_result_type,
                        parent,
                        false
                    )
                )
            }
            else -> throw IllegalArgumentException()
        }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = list[position].type.toInt()
        when (type) {
            0 -> (holder as NoticeTypeViewHolder).bindTo(list[position].noticeItem)
            1 -> (holder as ResultTypeViewHolder).bindTo(list[position].resultItem)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type.toInt()
    }

    fun updateTeamMain(updateList: List<TeamMainFeedItem>) {
        list.clear()
        list.addAll(updateList)
        notifyDataSetChanged()
    }

    inner class ResultTypeViewHolder(
        private val binding: RvItemTeamMainResultTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(resultItem: ResultItem?) {
            binding.resultItem = resultItem
            if (binding.resultItem!!.isWin) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.resultContent = Html.fromHtml(
                        String.format(
                            "<b>%s</b>과의 경기에서 승리하셨습니다.",
                            resultItem?.teamName
                        ), Html.FROM_HTML_MODE_COMPACT
                    )
                }
                binding.result = "WIN"
            } else {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    binding.resultContent = Html.fromHtml(
                        String.format(
                            "<b>%s</b>과의 경기에서 패배하셨습니다.",
                            resultItem?.teamName
                        ), Html.FROM_HTML_MODE_COMPACT
                    )
                }
                binding.result = "LOSE"
            }
        }
    }

    inner class NoticeTypeViewHolder(
        private val binding: RvItemTeamMainNoticeTypeBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(noticeItem: NoticeItem?) {
            binding.noticeItem = noticeItem
        }
    }


}
