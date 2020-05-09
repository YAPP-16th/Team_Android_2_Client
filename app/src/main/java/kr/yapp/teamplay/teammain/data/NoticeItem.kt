package kr.yapp.teamplay.teammain.data

import java.io.Serializable

data class NoticeItem(
    val title: String = "3월 2주 공지입니다",
    val createTime: String = "2020.3.9. 16:00",
    val content: String = "이번 주 토 3월 15일 오후 4시부터 7시 남양주 농구 동호회 팀 열정과 3대3 반코트 경기가 있습니다. 3대3 반코트 게임을 진행할 예정입니다. 게임 후 식사 및 간단하게 한 잔 있어요!"
) : Serializable
