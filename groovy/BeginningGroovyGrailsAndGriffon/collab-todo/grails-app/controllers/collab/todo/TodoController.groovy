package collab.todo

class TodoController {

    static scaffold = Todo

    def beforeInterceptor = {
        log.trace("${session?.user?.userName} Start action ${controllerName} Controller.${actionName} : parameters $params")
    }

    def afterInterceptor = { model ->
        log.trace("${session?.user?.userName} End action ${controllerName} Controller.${actionName} : returns $model")
    }
}
