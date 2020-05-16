package kr.yapp.teamplay.presentation.editpost

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kr.yapp.teamplay.R
import kr.yapp.teamplay.databinding.ActivityEditPostBinding

class EditPostActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditPostBinding

    private val viewModel: EditPostViewModel by lazy {
        ViewModelProvider(this).get(EditPostViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDataBinding()
        setLiveDataObserver()
        getPostInfo()
    }

    private fun getPostInfo() {
        viewModel.fetchPost({ message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }

    private fun setDataBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_post)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setLiveDataObserver() {
        viewModel.onWriteClick.observe(this, Observer {
            viewModel.setPost { message ->
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        })
    }
}