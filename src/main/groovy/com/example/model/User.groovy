package com.example.model

import grails.gorm.annotation.Entity
import org.grails.datastore.gorm.GormEntity

@Entity
class User implements GormEntity<User>{

    String username, password

}
