package org.elu.grailsinaction.qotd

/** Created by luhtonen on 14/10/15. */
class QuoteAnalyzer {
    private final List<Quote> quotes

    QuoteAnalyzer(List<Quote> quotes) {
        this.quotes = new ArrayList<>(quotes)
    }
    int getQuoteCount() {
        return this.quotes.size()
    }
}
