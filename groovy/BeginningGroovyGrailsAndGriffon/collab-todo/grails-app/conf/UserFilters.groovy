class UserFilters {
    def filters = {
        userModificationCheck(controller: 'user', action: '*') {
            before = {
                def currActionName = actionName
                if (currActionName == 'edit' || currActionName == 'update' || currActionName == 'delete') {
                    String userId = session?.user?.id
                    String paramsUserId = params?.id
                    if (userId != paramsUserId) {
                        flash.message = "You can only modify yourself"
                        redirect(action: 'index')
                        return false
                    }
                }
            }
        }
    }
}