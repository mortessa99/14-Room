package com.example.a21_room.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.a21_room.R
import com.example.a21_room.databinding.ActivityMainBinding
import com.example.a21_room.model.UserDatabase
import com.example.a21_room.model.UserRepository
import com.example.a21_room.viewmodel.UserViewModel
import com.example.a21_room.viewmodel.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        /////With this 6 line database created and worked.
        val dao = UserDatabase.instanceOfUserDatabase(applicationContext).userDao
        val repository = UserRepository(dao)
        val factory = UserViewModelFactory(repository)

        userViewModel = ViewModelProvider(this,factory).get(UserViewModel::class.java)
        binding.myViewModel = userViewModel
        binding.lifecycleOwner = this
        ///////////////////////////////////////////////








    }
}