package com.example.a21_room.model

class UserRepository(val dao: UserDao) {
    val users = dao.getAll()

    suspend fun insertUser(user: User){
        dao.insertUser(user)
    }

    suspend fun updateUser(user: User){
        dao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        dao.deleteUser(user)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }


}