package com.example.service

import com.example.model.User
import grails.gorm.transactions.Transactional
import jakarta.inject.Singleton

@Singleton
class UserService {

    @Transactional
    def findUserWithUsername(String username) {
       User.findByUsername(username)
    }

}
