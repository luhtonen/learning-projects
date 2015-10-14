package org.elu.grailsinaction.qotd

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
class QuoteAnalyzerSpec extends Specification {

    @Shared quotes = [
            new Quote(author: "Peter Ledbrook",
                    content: "Time waits for no man"),
            new Quote(author: "Glen Smith",
                    content: "Groovy solves all problems")
    ]

    @Unroll
    void "Total number of quotes"() {
        given: "An analyzer initialized with known quotes"
        def analyzer = new QuoteAnalyzer(inputQuotes)

        when: "I ask for the quote count"
        def quoteCount = analyzer.quoteCount

        then: "The number of quotes in the test list is returned"
        quoteCount == expected

        where:
        inputQuotes | expected
        []          | 0
        quotes      | 2
    }
}
