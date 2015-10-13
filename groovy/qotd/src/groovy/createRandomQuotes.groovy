/** Created by luhtonen on 13/10/15. */
def authors = [
        "Peter Ledbrook",
        "Glen Smith"
]
def quoteParts = [
        ["Time", "waits", "for no man"],
        ["The roundhouse kick", "solves", "all problems"],
        ["Groovy", "is", "the bees knees"]
]
String createQuote(List quoteParts, List authors) {
    def rand = new Random()
    def n = quoteParts.size()
    def m = authors.size()
    return quoteParts[rand.nextInt(n)][0] + ' ' +
            quoteParts[rand.nextInt(n)][1] + ' ' +
            quoteParts[rand.nextInt(n)][2] + ' by ' +
            authors[rand.nextInt(m)]
}
for (int i in 0..<10) {
    def quote = createQuote(quoteParts, authors)
    println quote
}
