package com.appvdev.examplemvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.appvdev.examplemvvm.R
import com.appvdev.examplemvvm.ViewModel.EngineListViewModel
import com.appvdev.examplemvvm.adapter.EngineAdapter
import com.appvdev.examplemvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: EngineListViewModel
    private val engineAdapter = EngineAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(EngineListViewModel::class.java)
        viewModel.refresh()

        binding.rvEngine.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = engineAdapter

        }
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.posts.observe(this) { postList ->
            postList?.let {
                engineAdapter.updatePostList(postList)
            }
        }
    }

}