package org.elu.grailsinaction.qotd

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(QuoteService)
class QuoteServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "static quote service always returns quiche quote"() {
        when:
        Quote staticQuote = service.staticQuote

        then:
        staticQuote.author == "Anonymous"
        staticQuote.content == "Real Programmers don't eat much quiche"
    }
}
