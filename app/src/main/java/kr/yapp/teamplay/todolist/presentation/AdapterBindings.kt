package kr.yapp.teamplay.todolist.presentation

import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kr.yapp.teamplay.todolist.data.Todo

@BindingAdapter("bind:item")
fun bindItem(recyclerView: RecyclerView, list: LiveData<List<Todo>>) {
    var todoAdapter: TodoAdapter = recyclerView.adapter as TodoAdapter
    todoAdapter.setItem(list)
}