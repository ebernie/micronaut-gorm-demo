package com.example.controller

import com.example.service.UserService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller('/users')
class UserController {

    UserService userService

    UserController(UserService userService) {
        this.userService = userService
    }

    @Get('/')
    def findUser(String username) {
        userService.findUserWithUsername(username)
    }

}
