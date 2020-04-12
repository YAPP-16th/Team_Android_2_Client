package kr.yapp.teamplay.todolist.domain

import android.app.Application
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import io.reactivex.Observable
import kr.yapp.teamplay.todolist.data.Todo
import kr.yapp.teamplay.todolist.data.TodoDao
import kr.yapp.teamplay.todolist.data.TodoDatabase

class TodoRepository(application: Application) {
    private val todoDao: TodoDao by lazy {
        val db = TodoDatabase.getInstance(application)
        db.todoDao()
    }

    val todos: LiveData<List<Todo>> by lazy {
        todoDao.getAllTodos()
    }

    fun getAllTodos(): LiveData<List<Todo>> {
        return todos
    }

    fun getTodoById(id: Long): LiveData<Todo> {
        return todoDao.getTodoById(id)
    }

    fun insert(todo: Todo): Observable<Unit> {
        return Observable.fromCallable {
            todoDao.insert(todo)
        }
    }

    fun delete(id: Long): Observable<Unit> {
        return Observable.fromCallable { todoDao.deleteById(id) }
    }

}