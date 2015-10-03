class UserFilters {
    def filters = {
        userModificationCheck(controller: 'user', action: '*') {
            before = {
                println "applying before filter for action ..."
                def currActionName = actionName
                println "checking action ..."
                if (currActionName == 'edit' || currActionName == 'update' || currActionName == 'delete') {
                    println "action checked"
                    String userId = session?.user?.id
                    String paramsUserId = params?.id
                    println "checking user id ..."
                    if (userId != paramsUserId) {
                        println "user id check failed, should stop action"
                        flash.message = "You can only modify yourself"
                        redirect(action: 'list')
                        return false
                    }
                    println "user id check passed"
                }
                println "action check passed"
            }
        }
    }
}