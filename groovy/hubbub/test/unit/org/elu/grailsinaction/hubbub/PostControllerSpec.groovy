package org.elu.grailsinaction.hubbub

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

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
        def id = chuck.loginId

        when: 'A timeline is invoked'
        def model = controller.timeline(id)

        then: 'the user is in the returned model'
        model.user.loginId == 'chuck_norris'
        model.user.posts.size() == 2
    }

    def "Check that non-existent users handled with an error"() {
        given: 'the id of non-existent user'
        def id = 'this-user-does-not-exist'

        when: 'the timeline is invoked'
        controller.timeline(id)

        then: 'a 404 is sent to the browser'
        response.status == 404
    }

    def "Adding a valid new post to the timeline"() {
        given: 'a mock post service'
        def mockPostService = Mock(PostService)
        1 * mockPostService.createPost(_, _) >> new Post(content: "Mock Post")
        controller.postService = mockPostService

        when: 'controller is invoked'
        def result = controller.addPost('joe_cool', 'Posting up a storm')

        then: 'redirected to timeline, flash message tells us all is well'
        flash.message ==~ /Added new post: Mock.*/
        response.redirectedUrl == '/post/timeline/joe_cool'
    }

    def "Adding empty content"() {
        given: 'a mock post service'
        def post = null
        def mockPostService = Mock(PostService)
        1 * mockPostService.createPost(_, _) >> {throw new PostException(message: 'Invalid or empty post', post: post)}
        controller.postService = mockPostService

        when: 'addPost is invoked'
        controller.addPost('joe_cool', post)

        then: 'flash message contains error message'
        flash.message == 'Invalid or empty post'
    }

    def "Adding post to non-existing user"() {
        given: 'a mock post service'
        def mockPostService = Mock(PostService)
        1 * mockPostService.createPost(_, _) >> {throw new PostException(message: 'Invalid user id')}
        controller.postService = mockPostService

        and: 'An invalid loginId'
        def id = 'non-existing-user'

        when: 'addPost is invoked'
        controller.addPost(id, 'content')

        then: 'flash message contains error message'
        flash.message == 'Invalid user id'
    }

    @Unroll
    def "Testing id of #suppliedId redirects to #expectedUrl"() {
        given:
        params.id = suppliedId

        when: "Controller is invoked"
        controller.home()

        then:
        response.redirectedUrl == expectedUrl

        where:
        suppliedId | expectedUrl
        'joe_cool' | '/post/timeline/joe_cool'
        null       | '/post/timeline/chuck_norris'
    }
}
