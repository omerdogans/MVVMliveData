package com.appvdev.examplemvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.appvdev.examplemvvm.Model.Post
import com.appvdev.examplemvvm.R
import com.appvdev.examplemvvm.databinding.EngineItemBinding

class EngineAdapter(private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<EngineViewHolder>() {

    fun updatePostList(newUpdatePosts: List<Post>) {
        postList.clear()
        postList.addAll(newUpdatePosts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EngineViewHolder {
        return EngineViewHolder(EngineItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
        //val inflater = LayoutInflater.from(parent.context)
        //val view = inflater.inflate(R.layout.engine_item,parent,false)
        //return EngineViewHolder(view)
    }

    override fun onBindViewHolder(holder: EngineViewHolder, position: Int) {

        val post = postList[position]
        holder.bindItem(post)

        //holder.id.text = postList[position].id.toString()
        //holder.title.text= postList[position].title
        //holder.body.text = postList[position].body

    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

class EngineViewHolder(val binding: EngineItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(post: Post) {
        binding.tvId.text = post.id.toString()
        binding.tvName.text = post.title
        binding.tvBody.text = post.body
    }
    /*  val id: TextView = view.findViewById(R.id.tvId)
    val body: TextView = view.findViewById(R.id.tvBody)
    val title: TextView = view.findViewById(R.id.tvName)*/


}