package org.elu.grailsinaction.qotd

class QuoteController {

    static scaffold = true
    static defaultAction = "home"
    def quoteService

    def home() {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }

    def random () {
        def randomQuote = quoteService.randomQuote
        [ quote: randomQuote ]
    }
}
