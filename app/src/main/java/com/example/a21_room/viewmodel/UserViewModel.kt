package com.example.a21_room.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.a21_room.model.User
import com.example.a21_room.model.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(val repository: UserRepository) : ViewModel() , Observable {
    val users = repository.users

    var isUpdateOrDelete = false
    lateinit var userToUpdateOrDelete:User

    @Bindable
    var inputName = MutableLiveData<String?>()
    @Bindable
    var inputEmail = MutableLiveData<String?>()

    @Bindable
    var saveOrUpdateButton = MutableLiveData<String>()
    @Bindable
    var deleteOrDeleteAllButton = MutableLiveData<String>()

    init {
        saveOrUpdateButton.value = "Save"
        deleteOrDeleteAllButton.value = "Delete All"
    }


    fun initUpdateOrDelete(user:User){
        inputName.value = user.name
        inputEmail.value = user.email
        saveOrUpdateButton.value = "Update"
        deleteOrDeleteAllButton.value = "Delete User"
        isUpdateOrDelete = true
        userToUpdateOrDelete = user
    }





    fun saveOrUpdate(){
        if (isUpdateOrDelete){
            userToUpdateOrDelete.name = inputName.value!!
            userToUpdateOrDelete.email = inputEmail.value!!
            update(userToUpdateOrDelete)
            inputName.value = null
            inputEmail.value = null
        } else {
            insert(User(0,inputName.value!!,inputEmail.value!!))
            inputName.value = null
            inputEmail.value = null
        }

    }

    fun deleteOrDeleteAll(){
        if (isUpdateOrDelete){
            delete(userToUpdateOrDelete)
        } else{
            viewModelScope.launch {
                repository.deleteAll()
            }
        }
    }

    fun insert(user: User){
        viewModelScope.launch {
            repository.insertUser(user)
        }
    }

    fun delete(user: User){
        viewModelScope.launch {
            repository.deleteUser(user)
            inputName.value = null
            inputEmail.value = null
            isUpdateOrDelete = false
            saveOrUpdateButton.value = "Save"
            deleteOrDeleteAllButton.value = "Delete All"
        }
    }

    fun update(user: User){
        viewModelScope.launch {
            repository.updateUser(user)
        }
    }


    //this is implementaion of Observable
    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        //
    }

}

