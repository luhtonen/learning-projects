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

    @Unroll
    def "Registration command object for #loginId validate correctly"() {
        given: 'a mocked command object'
        def urc = mockCommandObject(UserRegistrationCommand)

        and: 'a set of initial values from the spock test'
        urc.loginId = loginId
        urc.password = password
        urc.passwordRepeat = passwordRepeat
        urc.fullName = 'Your Name Here'
        urc.email = 'someone@nowhere.net'

        when: 'the validator is invoked'
        def isValidRegistration = urc.validate()

        then: 'the appropriate fields are flagged as errors'
        isValidRegistration == anticipatedValid
        urc.errors.getFieldError(fieldInError)?.code == errorCode

        where:
        loginId | password   | passwordRepeat | anticipatedValid | fieldInError     | errorCode
        'glen'  | 'password' | 'no-match'     | false            | 'passwordRepeat' | 'validator.invalid'
        'peter' | 'password' | 'password'     | true             | null             | null
        'a'     | 'password' | 'password'     | false            | 'loginId'        | 'size.toosmall'
    }

    def "Invoking the new register action via a command object"() {
        given: 'A configured command object'
        def urc = mockCommandObject(UserRegistrationCommand)
        urc.with {
            loginId = 'edu_finn'
            fullName = 'Edu Finn'
            email = 'edufinn@gmail.com'
            password = 'password'
            passwordRepeat = 'password'
        }

        and: 'which has been validated'
        urc.validate()

        when: 'the register action is invoked'
        controller.register2(urc)

        then: 'the user is registered and browser redirected'
        !urc.hasErrors()
        response.redirectedUrl == '/'
        User.count() == 1
        Profile.count() == 1
    }
}
