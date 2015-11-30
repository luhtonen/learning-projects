package org.elu.grailsinaction.hubbub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PostController)
@Mock([User,Post])
class PostControllerSpec extends Specification {

    void "Get a users timeline given their id"() {
        given: 'A user with posts in db'
        User chuck = new User(loginId: 'chuck_norris', password: 'password')
        chuck.addToPosts(new Post(content: 'A first post'))
        chuck.addToPosts(new Post(content: 'A second post'))
        chuck.save(failOnError: true)

        and: 'A loginId parameters'
        params.id = chuck.loginId

        when: 'A timeline is invoked'
        def model = controller.timeline()

        then: 'the user is in the returned model'
        model.user.loginId == 'chuck_norris'
        model.user.posts.size() == 2
    }
}
