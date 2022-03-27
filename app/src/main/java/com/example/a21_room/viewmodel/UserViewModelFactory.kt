package com.example.a21_room.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a21_room.model.UserRepository

class UserViewModelFactory(val repositoty:UserRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            return UserViewModel(repositoty) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}