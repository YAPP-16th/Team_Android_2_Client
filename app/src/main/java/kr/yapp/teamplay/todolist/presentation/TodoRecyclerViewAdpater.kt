package kr.yapp.teamplay.todolist.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todolist.view.*
import kr.yapp.teamplay.databinding.ItemTodolistBinding
import kr.yapp.teamplay.todolist.data.Todo


class TodoAdapter(private val click: (Long) -> Unit) : RecyclerView.Adapter<TodoAdapter.ViewHolder>() {

    lateinit var list: List<Todo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemTodolistBinding = ItemTodolistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun setItem(list: LiveData<List<Todo>>) {
        this.list = list.value?: arrayListOf()
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemTodolistBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Todo) {
            binding.todo = item
        }
    }
}