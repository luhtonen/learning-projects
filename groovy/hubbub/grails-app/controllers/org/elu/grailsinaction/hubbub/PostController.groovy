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
}
