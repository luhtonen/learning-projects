package transformations

import groovy.util.logging.Log

@Log
class Test {
    def someMethod() {
        log.fine('complexMethod()')
    }
}
def t = new Test()
t.someMethod()
