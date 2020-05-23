package kr.yapp.teamplay.presentation.util

interface Bindable<in ITEM : BindableData> {
    fun bindTo(item: ITEM)
}

