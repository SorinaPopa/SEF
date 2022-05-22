package com.example.stadevents.login.business

class UserMapper {
    companion object {
        fun getUsersList(): List<User> {
            return mutableListOf(User("user","user"),User("password","password"))
        }
    }
}