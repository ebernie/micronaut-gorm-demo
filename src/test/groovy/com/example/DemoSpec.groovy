package com.example

import com.example.model.User
import grails.gorm.transactions.Transactional
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.annotation.Client
import io.micronaut.rxjava2.http.client.RxHttpClient
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification

@MicronautTest
class DemoSpec extends Specification {

    @Inject
    @Client('/')
    RxHttpClient client

    @Transactional
    def setupSpec() {
        new User(username: 'user1', password: '123456').save()
    }

    void 'test find user'() {

        when:
        def req = HttpRequest.GET('/users/?username=user1')
        def user = client.toBlocking().exchange(req, User).body()

        then:
        user.username == 'user1'
        user.password == '123456'
    }

}
