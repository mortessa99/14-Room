package com.example.a21_room.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class] , version = 1)
abstract class UserDatabase : RoomDatabase(){
    abstract val userDao:UserDao

    companion object{
        private var INSTANCE:UserDatabase?=null

        fun instanceOfUserDatabase(context: Context) : UserDatabase {
            synchronized(this){
                var instance:UserDatabase?=INSTANCE
                //var instance:UserDatabase?=null
                if (instance == null) {
                    instance = Room.databaseBuilder(context.applicationContext,UserDatabase::class.java,"my_database").build()
                }
                return instance
            }
        }
    }
}