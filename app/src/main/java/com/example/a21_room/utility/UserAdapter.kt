package com.example.a21_room.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.a21_room.R
import com.example.a21_room.databinding.ItemsBinding
import com.example.a21_room.model.User

class UserAdapter(val users:List<User>) : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding:ItemsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.items,parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
       return users.size
    }
}

class UserViewHolder(val binding:ItemsBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User) {
        binding.textViewId.text = user.id.toString()
        binding.textViewName.text = user.name
        binding.textViewEmail.text = user.email
    }
}