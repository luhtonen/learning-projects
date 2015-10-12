package org.elu.grailsinaction.qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def getStaticQuote() {
        return new Quote(author: 'Anonymous', content: "Real Programmers don't eat much quiche")
    }

    def getRandomQuote() {
        def allQuotes = Quote.list()
        def randomQuote
        if (allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = getStaticQuote()
        }
        [ quote: randomQuote ]
    }
}
