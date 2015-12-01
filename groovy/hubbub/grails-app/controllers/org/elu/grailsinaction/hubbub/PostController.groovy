package org.elu.grailsinaction.hubbub

class PostController {
    static scaffold = true

    def index() {
        if (!params.id) {
            params.id = 'chuck_norris'
        }
        redirect(action: 'timeline', params: params)
    }

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
                    flash.message = 'Successfully created post'
                } else {
                    flash.message = 'Invalid or empty post'
                }
            }
        } else {
            flash.message = 'Invalid user id'
        }
        redirect(action: 'timeline', id: params.id)
    }
}
