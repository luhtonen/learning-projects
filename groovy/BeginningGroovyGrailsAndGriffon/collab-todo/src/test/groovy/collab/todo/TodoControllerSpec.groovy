package collab.todo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(TodoController)
class TodoControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test TodoController's index() method"() {
        controller.index()
        expect:"should render text 'create new tasks'"
            'create new tasks' == response.text
    }
}
