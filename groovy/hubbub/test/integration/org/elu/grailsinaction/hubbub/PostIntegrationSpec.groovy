package org.elu.grailsinaction.hubbub

import grails.test.spock.IntegrationSpec

class PostIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "Adding posts to user links post to user"() {
        given: "A brand new user"
        def user = new User(loginId: 'joe', password: 'secret')
        user.save(failOnError: true)

        when: "Several posts are added to the user"
        user.addToPosts(new Post(content: 'First post... W00t!'))
        user.addToPosts(new Post(content: 'Second post...'))
        user.addToPosts(new Post(content: 'Third post...'))

        then: "The user have the list of posts attached"
        3 == User.get(user.id).posts.size()
    }

    void "Ensure posts linked to a user can be retrieved"() {
        given: "A user with several posts"
        def user = new User(loginId: 'joe', password: 'secret')
        user.addToPosts(new Post(content: 'First'))
        user.addToPosts(new Post(content: 'Second'))
        user.addToPosts(new Post(content: 'Third'))
        user.save(failOnError: true)

        when: "The user is retrieved by their id"
        def foundUser = User.get(user.id)
        def sortedPostContent = foundUser.posts.collect { it.content }.sort()

        then: "The posts appear on the retrieved user"
        sortedPostContent == ['First', 'Second', 'Third']
    }
}
