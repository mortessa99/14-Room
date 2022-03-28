package com.example.a21_room.utility

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.a21_room.R
import com.example.a21_room.databinding.ItemsBinding
import com.example.a21_room.generated.callback.OnClickListener
import com.example.a21_room.model.User
import com.example.a21_room.model.UserDao
import com.example.a21_room.model.UserRepository
import com.example.a21_room.viewmodel.UserViewModel

class UserAdapter(val users:List<User> , val onClickListener: (User) -> Unit) : RecyclerView.Adapter<UserViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var binding:ItemsBinding = DataBindingUtil.inflate(layoutInflater, R.layout.items,parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], onClickListener)
    }

    override fun getItemCount(): Int {
       return users.size
    }
}

class UserViewHolder(val binding:ItemsBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(user: User,onClickListener: (User) -> Unit) {
        binding.textViewId.text = user.id.toString()
        binding.textViewName.text = user.name
        binding.textViewEmail.text = user.email
        binding.constraintLayout.setOnClickListener {
            //Toast.makeText(it.context,user.name,Toast.LENGTH_LONG).show()
            onClickListener(user)
        }
    }
}