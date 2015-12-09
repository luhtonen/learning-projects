package org.elu.grailsinaction.hubbub

class LameSecurityFilters {

    def filters = {
        secureActions(controller: 'post', action: '(addPost|deletePost)') {
            before = {
                if (params.impersonateId) {
                    session.user = User.findByLoginId(params.impersonateId)
                }
                if (!session.user) {
                    redirect(controller: 'login', action: 'form')
                }
            }
            after = { model ->
            }
            afterView = {
                log.debug "Finished running ${controllerName} - ${actionName}"
            }
        }
    }
}
