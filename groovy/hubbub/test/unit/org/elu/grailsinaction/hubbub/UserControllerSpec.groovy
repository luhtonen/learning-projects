package org.elu.grailsinaction.hubbub

import grails.test.mixin.*
import spock.lang.*

@TestFor(UserController)
@Mock([User, Profile])
class UserControllerSpec extends Specification {

    def "Register user with known good parameters"() {
        given: 'a set of user parameters'
        params.with {
            loginId = 'edu_finn'
            password = 'password'
            homepage = 'http://luhtonen.github.io'
        }

        and: 'a set of profile parameters'
        params['profile.fullName'] = 'Edu Finn'
        params['profile.email'] = 'edufinn@gmail.com'
        params['profile.homepage'] = 'http://luhtonen.github.io'

        when: 'a user is registered'
        request.method = 'POST'
        controller.register()

        then: 'the user is created, and browser redirects'
        response.redirectedUrl == '/'
        User.count() == 1
        Profile.count() == 1
    }
}
