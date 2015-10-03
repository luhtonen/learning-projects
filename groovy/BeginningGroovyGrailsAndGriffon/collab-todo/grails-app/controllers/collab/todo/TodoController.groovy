package collab.todo

class TodoController {

    static scaffold = Todo

    def beforeInterceptor = [action: this.&beforeAudit, except: ['list']]
    def afterInterceptor = [action: {model -> this.&afterAudit(model)}, except: ['list']]
    def beforeAudit = {
        log.trace("${session?.user?.userName} Start action ${controllerName} Controller.${actionName} : parameters $params")
    }
    def afterAudit = { model ->
        log.trace("${session?.user?.userName} End action ${controllerName} Controller.${actionName} : returns $model")
    }
}
