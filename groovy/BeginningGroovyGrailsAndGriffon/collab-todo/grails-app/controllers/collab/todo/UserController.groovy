package collab.todo

class UserController {

    static scaffold = User
    def login() {}
    def handleLogin() {
        def user = User.findByUserName(params.userName)
        if (!user) {
            flash.message = "User not found userName: ${params.userName}"
            redirect(action: 'login')
        } else {
            session.user = user
            redirect(controller: 'todo')
        }
    }
    def logout() {
        if (session.user) {
            session.user = null
            redirect(action: 'login')
        }
    }
    def save() {
        def user = new User()
        user.properties = params
        if (user.save()) {
            flash.message = "user.saved.message"
            flash.args = [user.firstName, user.lastName]
            flash.defaultMsg = "User Saved"
            redirect(action: 'show', id: user.id)
        } else {
            render(view: 'create', model: [user: user])
        }
    }
}
