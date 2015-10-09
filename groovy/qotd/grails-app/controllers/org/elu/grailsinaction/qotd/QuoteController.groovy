package org.elu.grailsinaction.qotd

class QuoteController {

    static scaffold = true
    static defaultAction = "home"

    def home() {
        render "<h1>Real Programmers do not eat Quiche</h1>"
    }

    def random () {
        def allQuotes = Quote.list()
        def randomQuote
        if (allQuotes.size() > 0) {
            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]
        } else {
            randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers don't eat much quiche")
        }
        [ quote: randomQuote ]
    }
}
