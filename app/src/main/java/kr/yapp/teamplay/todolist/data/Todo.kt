package kr.yapp.teamplay.todolist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "todo")
data class Todo (
    @PrimaryKey(autoGenerate = true)
    val id : Long? = null,
    @ColumnInfo(name = "title")
    val title : String,
    @ColumnInfo(name = "content")
    val content : String,
    @ColumnInfo(name = "done")
    val done : Boolean
) : Serializable