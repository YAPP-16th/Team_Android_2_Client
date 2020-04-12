package kr.yapp.teamplay.todolist.presentation

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityTodoBinding
import kr.yapp.teamplay.todolist.data.Todo

class TodoActivity : AppCompatActivity() {

    companion object {
        private const val TAG: String = "TodoActivity"
    }

    private lateinit var binding: ActivityTodoBinding

    private lateinit var viewModelFactory: TodoViewModelFactory

    private lateinit var todoViewModel: TodoViewModel

    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        setDataBinding()
        setLiveDataObserver()
        setRecyclerView()
    }


    override fun onResume() {
        super.onResume()
        todoViewModel.getAllTodos()
    }

    private fun setViewModel() {
        viewModelFactory = TodoViewModelFactory(application)
        todoViewModel = ViewModelProvider(this, viewModelFactory).get(TodoViewModel::class.java)
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_todo)
        binding.lifecycleOwner = this
        binding.viewModel = todoViewModel
    }


    private fun setLiveDataObserver() {
    }

    private fun setRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = TodoAdapter() { Toast.makeText(this, "123", Toast.LENGTH_LONG).show() }
        binding.recyclerview.adapter = adapter
    }

}