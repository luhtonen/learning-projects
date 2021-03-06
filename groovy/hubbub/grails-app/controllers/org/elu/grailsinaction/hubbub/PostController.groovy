package org.elu.grailsinaction.hubbub

class PostController {
    static scaffold = true
    static defaultAction = 'home'

    def postService

    def home() {
        if (!params.id) {
            params.id = 'chuck_norris'
        }
        redirect(action: 'timeline', params: params)
    }

    def timeline(String id) {
        def user = User.findByLoginId(id)
        if (!user) {
            response.sendError(404)
        } else {
            [user: user]
        }
    }

    def addPost(String id, String content) {
        try {
            def newPost = postService.createPost(id, content)
            flash.message = "Added new post: ${newPost.content}"
        } catch (PostException ex) {
            flash.message = ex.message
        }
        redirect(action: 'timeline', id: id)
    }
}
