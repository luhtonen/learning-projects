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

    Map<String, Integer> getQuoteCountPerAuthor() {
        def result = [:]
        for (Quote quote : quotes) {
            if (result.containsKey(quote.author)) {
                result[quote.author] = result[quote.author] + 1
            } else {
                result[quote.author] = 1
            }
        }
        return result
    }
}
