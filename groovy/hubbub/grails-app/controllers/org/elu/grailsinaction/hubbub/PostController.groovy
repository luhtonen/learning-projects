package org.elu.grailsinaction.hubbub

class PostController {
    static scaffold = true

    def timeline() {
        def user = User.findByLoginId(params.id)
        if (!user) {
            response.sendError(404)
        } else {
            [ user: user ]
        }
    }

    def addPost() {
        def user = User.findByLoginId(params.id)
        if (user) {
            def post = new Post(params)
            user.addToPosts(post)
            User.withTransaction {
                if (user.save()) {
                    println 'saved ###'
                    println 'post ' + post + ' with content ' + post?.content
                    flash.message = 'Successfully created post'
                } else {
                    println 'error'
                    flash.message = 'Invalid or empty post'
                }
            }
        } else {
            println 'user not found'
            flash.message = 'Invalid user id'
        }
        println 'user ' + user.loginId + ' with posts ' + user.posts
        redirect(action: 'timeline', id: params.id)
    }
}
