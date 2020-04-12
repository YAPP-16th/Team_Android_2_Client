package kr.yapp.teamplay.todolist.presentation

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kr.yapp.teamplay.todolist.data.Todo
import kr.yapp.teamplay.todolist.domain.TodoRepository

class TodoViewModel(
    private val application: Application
) : ViewModel() {
    private val TAG: String = "TodoViewModel"

    var title = MutableLiveData<String>()
    var content = MutableLiveData<String>()

    val list : LiveData<List<Todo>>
        get() = repository.getAllTodos()

    private val disposable: CompositeDisposable = CompositeDisposable()

    private val repository: TodoRepository by lazy {
        TodoRepository(application)
    }

    fun getAllTodos() = list

    fun getTodoById(id: Long): LiveData<Todo> {
        return repository.getTodoById(id)
    }

    fun insert() {
        val todo = Todo(title = title.value?: "null", content = content.value?: "null", done = false)
        disposable.add(repository.insert(todo).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        )
    }

    fun delete(id: Long) {
        disposable.add( repository.delete(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}