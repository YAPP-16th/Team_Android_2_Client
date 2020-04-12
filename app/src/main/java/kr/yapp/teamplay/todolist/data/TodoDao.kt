package kr.yapp.teamplay.todolist.data

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insert(todo: Todo)

    @Update
    fun update(todo: Todo)

    @Query("SELECT * FROM todo ORDER BY id DESC")
    fun getAllTodos(): LiveData<List<Todo>>

    @Query("DELETE FROM todo WHERE id = :id")
    fun deleteById(id: Long)

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoById(id: Long): LiveData<Todo>
}
