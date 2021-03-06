package org.elu.grailsinaction.hubbub

import grails.test.spock.IntegrationSpec

class UserIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Save our first user to database"() {
        given: "A brand new user"
        def joe = new User(loginId: 'joe', password: 'secret')

        when: "the user is saved"
        joe.save()

        then: "it saved successfully and can be found in the database"
        joe.errors.errorCount == 0
        joe.id != null
        User.get(joe.id).loginId == joe.loginId
    }

    def "Updating a saved user changes its properties"() {
        given: "An existing user"
        def existingUser = new User(loginId: 'joe', password: 'secret')
        existingUser.save(failOnError: true)

        when: "A property is changed"
        def foundUser = User.get(existingUser.id)
        foundUser.password = 'sesame'
        foundUser.save(failOnError: true)

        then: "The change is reflected in the database"
        User.get(existingUser.id).password == 'sesame'
    }

    def "Deleting an existing user removes it from the database"() {
        given: "An existing user"
        def user = new User(loginId: 'joe', password: 'secret')
        user.save(failOnError: true)

        when: "The user is deleted"
        def foundUser = User.get(user.id)
        foundUser.delete(flush: true)

        then: "The user is removed from the database"
        !User.exists(foundUser.id)
    }

    def "Saving a user with invalid password causes an error"() {
        given: "A user which fails several field validations"
        def user = new User(loginId: 'joe', password: 'tiny')

        when: "User is validated"
        user.validate()

        then:
        user.hasErrors()

        'size.toosmall' == user.errors.getFieldError('password').code
        'tiny' == user.errors.getFieldError('password').rejectedValue
        !user.errors.getFieldError('loginId')
     }

    def "Recovering from a failed save by fixing invalid properties"() {
        given: "A user that has invalid properties"
        def chuck = new User(loginId: 'chuck', password: 'tiny')
        assert chuck.save() == null
        assert chuck.hasErrors()

        when: "We fix the invalid properties"
        chuck.password = 'fistfist'
        chuck.validate()

        then: "The user saves and validates fine"
        !chuck.hasErrors()
        chuck.save()
    }

    def "Ensure a user can follow other users"() {
        given: "A set of baseline users"
        def arno = new User(loginId: 'arno', password:'password').save()
        def lauri = new User(loginId: 'lauri', password:'password').save()
        def kristian = new User(loginId: 'kristian', password:'password').save()
        def karoliina = new User(loginId: 'karoliina', password:'password').save()

        when: "Karoliina follows Arno, Lauri & Kristian, Kristian follows Lauri and Arno and Lauri follows Arno"
        karoliina.addToFollowing(arno)
        karoliina.addToFollowing(lauri)
        karoliina.addToFollowing(kristian)
        kristian.addToFollowing(arno)
        kristian.addToFollowing(lauri)
        lauri.addToFollowing(arno)

        then: "Follower counts should match following people"
        3 == karoliina.following.size()
        2 == kristian.following.size()
        1 == lauri.following.size()
    }
}
